package com.example.mybtapplicationkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.braintreepayments.api.dropin.DropInActivity
import com.braintreepayments.api.dropin.DropInRequest
import com.braintreepayments.api.dropin.DropInResult
import com.braintreepayments.api.models.GooglePaymentRequest
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.TextHttpResponseHandler
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.activity_main.*
import com.braintreepayments.api.models.VenmoAccountNonce
import com.braintreepayments.api.dropin.utils.PaymentMethodType




class MainActivity : AppCompatActivity() {

    internal var token: String = "sandbox_csw9xrst_wvy3387d3q8dc9v4"
    internal lateinit var amount: String
    internal var paramsHash: HashMap<String, String>? = null

    companion object {
        val API_GET_TOKEN = "http://10.0.2.2/braintree/main.php"
        val API_CHECKOUT = "http://10.0.2.2/braintree/main.php"
        val REQUEST_CODE = 7777

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getToken()

        btn_pay.setOnClickListener {
            val dropInRequest = DropInRequest()
                .clientToken(token)
                .collectDeviceData(true)
                //.collectDeviceData(Settings.shouldCollectDeviceData(this))
                //.requestThreeDSecureVerification(Settings.isThreeDSecureEnabled(this))

            startActivityForResult(dropInRequest.getIntent(this), REQUEST_CODE)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getParcelableExtra<DropInResult>(DropInResult.EXTRA_DROP_IN_RESULT)
                val nonce = result?.paymentMethodNonce
                val stringNonce = nonce!!.nonce
                val deviceData = result.deviceData

                if (!edt_payment.text.toString().isEmpty()) {
                    amount = edt_payment.text.toString();
                    paramsHash = HashMap()
                    paramsHash!!["amount"] = amount
                    paramsHash!!["nonce"] = stringNonce
                    sendPayments()
                }
                if (result.paymentMethodType === PaymentMethodType.PAY_WITH_VENMO) {
                    val venmoAccountNonce = result.paymentMethodNonce as VenmoAccountNonce
                    val venmoUsername = venmoAccountNonce.username
                }
                else {
                    Toast.makeText(this@MainActivity, "Invalid", Toast.LENGTH_SHORT)
                        .show()
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this@MainActivity, "Cancel", Toast.LENGTH_SHORT)
                    .show()
            } else {
                // handle errors here, an exception may be available in
                val error = data!!.getSerializableExtra(DropInActivity.EXTRA_ERROR) as Exception
                Log.e("EDMT_ERROR", error.message)
            }
        }
    }

    private fun sendPayments() {
        val queue = Volley.newRequestQueue(this@MainActivity)
        val stringRequest = object : StringRequest(
            Request.Method.POST,
            API_CHECKOUT,
            Response.Listener { response ->
                if (response.toString().contains("Successful"))
                    Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this@MainActivity, "Failed", Toast.LENGTH_SHORT).show()
            }, Response.ErrorListener { error ->
                Log.e("EDMT_ERROR", "Volley error: ${error.message}")
            }) {
            override fun getParams(): HashMap<String, String?>? {
                if (paramsHash == null)
                    return null
                var params = HashMap<String, String?>()
                for (key in paramsHash!!.keys) {
                    params.set(key, paramsHash!![key])
                }
                return params
            }

            override fun getHeaders(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["Content-Type"] = "application/x-www-form-urlencoded"
                return params
            }
        }
    }


    private fun getToken() {
        val androidClient = AsyncHttpClient()
        androidClient.get(API_GET_TOKEN, object : TextHttpResponseHandler() {

            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseString: String?) {
                runOnUiThread {
                    //                    payment_group.visibility = View.VISIBLE
                    responseString?.let { token = it }
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseString: String?,
                throwable: Throwable?
            ) {
                runOnUiThread {
                    Toast.makeText(
                        this@MainActivity,
                        "Failed to get token : ${throwable.toString()}",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

        })
    }
}

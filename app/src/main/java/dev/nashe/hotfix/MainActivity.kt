package dev.nashe.hotfix

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val className = "dev.nashe.hotfix.test.TestLib"
    val methods = arrayOf("getVersionString")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hotpatch = Hotpatch()
        val hotpatchPath = "$filesDir/app.jar"

        try {
            //github.com's ssl-certificate public key, hashed with sha256.
            //You can obtain a public key hash running by running:
            // ./get_key_sha256.sh github.com
            hotpatch.addSecureDomain(
                "https://github.com",
                "sha256/pL1+qb9HTMRZJmuC/bB/ZI9d302BYrrqiVuRyW+DGrU="
            )
            hotpatch.downloadHotpatch("https://github.com/RabbiNash/Hotfix/tree/main/app/libs/app.jar",
                hotpatchPath,
                object : Hotpatch.Callback() {
                    override fun run() {
                        try {
                            hotpatch.loadLibrary(hotpatchPath, applicationContext)
                            hotpatch.loadClass(className)
                            hotpatch.loadMethods(className, methods)
                            val result = hotpatch.call(className, methods[0]) as String
                            val update_text = Intent("update-textview")
                            update_text.putExtra("version", result)
                            Log.d("MainActivity", result)
                            sendBroadcast(update_text)
                        } catch (e: Exception) {
                            Log.e("AndroidHotpatch", Log.getStackTraceString(e))
                        }
                    }
                })
        } catch (e: Exception) {
            Log.e("AndroidHotpatch", Log.getStackTraceString(e))
        }

        Log.e("MainActivity", Fix.a("good"))
        Log.e("MainActivity"," ${Fix().b("s1", "s2")}")
        Log.e("MainActivity", " ${Fix.i}")
    }
}
package dev.nashe.hotfix

import android.app.Application
import android.os.Environment
import android.util.Log
import com.alipay.euler.andfix.patch.PatchManager
import java.io.IOException

class HotFix : Application() {
    private val APATCH_PATH = "/out.apatch"
    private var mPatchManager: PatchManager? = null

    override fun onCreate() {
        super.onCreate()

        initialisePatchManager()
    }

    private fun initialisePatchManager() {
        mPatchManager = PatchManager(this)
        mPatchManager?.init(PATCH_VERSION)

        // load patch
        mPatchManager?.loadPatch()
        Log.d("App","apatch loaded.")

        // add patch at runtime
        try {
            // .apatch file path
            val patchFileString: String = Environment.getExternalStorageDirectory()
                .absolutePath.toString() + APATCH_PATH
            mPatchManager?.addPatch(patchFileString)
            Log.d("apatch", ":$patchFileString added.")
        } catch (e: IOException) {
            Log.e("apatch", ":${e.message} added.")
        }
    }

    companion object {
        const val TAG = "Glasses"
        const val PATCH_VERSION = "1.0"
    }
}
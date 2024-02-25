package com.softland.vsitorapp.ui.theme.Utilss

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.provider.Settings
import java.io.File
import java.io.FileOutputStream

class FileUtils {

    companion object{

        @SuppressLint("HardwareIds")
        fun get_android_id(ctx: Context): String? {
            return Settings.Secure.getString(ctx.contentResolver, "android_id")
        }

        fun  uriToFile(context: Context , uri: Uri): File {
            val contentResolver: ContentResolver = context.contentResolver
            val fileName = "converted_file"
            val fileExtension = getFileExtension(contentResolver, uri)

            // Create a temporary file
            val file = File(context.cacheDir, "$fileName.$fileExtension")

            // Copy data from the Uri to the file
            try {
                contentResolver.openInputStream(uri)?.use { inputStream ->
                    FileOutputStream(file).use { outputStream ->
                        val buffer = ByteArray(4 * 1024)
                        var read: Int
                        while (inputStream.read(buffer).also { read = it } != -1) {
                            outputStream.write(buffer, 0, read)
                        }
                        outputStream.flush()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return file
        }

        private fun getFileExtension(contentResolver: ContentResolver , uri: Uri): String {
            return if ("content" == uri.scheme) {
                val mime = contentResolver.getType(uri)
                mime?.substringAfter('/') ?: "unknown"
            } else {
                uri.pathSegments.lastOrNull()?.substringAfterLast('.') ?: "unknown"
            }
        }
    }

}
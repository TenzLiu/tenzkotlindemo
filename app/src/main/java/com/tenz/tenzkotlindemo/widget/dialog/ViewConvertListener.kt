package com.tenz.tenzkotlindemo.widget.dialog

import java.io.Serializable

interface ViewConvertListener: Serializable{

    fun convertView(holder: ViewHolder, dialog: BaseDialog)

}
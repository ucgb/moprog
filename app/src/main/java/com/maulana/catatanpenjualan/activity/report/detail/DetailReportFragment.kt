package com.maulana.catatanpenjualan.activity.report.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.maulana.catatanpenjualan.R
import com.maulana.catatanpenjualan.activity.report.adapter.ReportDetailAdapter
import com.maulana.catatanpenjualan.activity.report.data.ResultItemKeranjang
import com.maulana.catatanpenjualan.activity.report.presenter.DetailReportPresenter
import com.maulana.catatanpenjualan.model.Keranjang
import com.maulana.catatanpenjualan.utils.Uang
import kotlinx.android.synthetic.main.fragment_detail_report.*

class DetailReportFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_report, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val data = arguments?.getSerializable("penjualan")

        if (data != null) {
            val penjualan = data as Keranjang

            DetailReportPresenter()
                .getPenjualan(Integer.parseInt(penjualan.idUser),Integer.parseInt(penjualan.idKeranjang), object: DetailReportPresenter.OnResult{
                    override fun onFailed(msg: String?) {

                    }
                    override fun onResult(resultItemKeranjang: ResultItemKeranjang) {
                        list?.adapter = ReportDetailAdapter(resultItemKeranjang)
                        tvStatus?.text = resultItemKeranjang.keranjang?.status
                        tvQty?.text = resultItemKeranjang.keranjang?.qty.toString()
                        tvGrandTotal?.text = resultItemKeranjang.keranjang?.totalHarga?.let {
                            Uang.indonesia(it)
                        }
                    }

                })
        }
    }
}
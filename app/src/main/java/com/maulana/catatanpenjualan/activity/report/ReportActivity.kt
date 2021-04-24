package com.maulana.catatanpenjualan.activity.report

import android.os.Bundle
import android.util.Log
import com.maulana.catatanpenjualan.R
import com.maulana.catatanpenjualan.activity.report.adapter.ReportAdapter
import com.maulana.catatanpenjualan.activity.report.detail.DetailReportFragment
import com.maulana.catatanpenjualan.activity.report.presenter.ReportPresenter
import com.maulana.catatanpenjualan.activity.report.presenter.ReportView
import com.maulana.catatanpenjualan.base.BaseActivity
import com.maulana.catatanpenjualan.model.Keranjang
import com.maulana.catatanpenjualan.model.KeranjangStatus
import kotlinx.android.synthetic.main.activity_report.*
import org.jetbrains.anko.toast

class ReportActivity : BaseActivity(), ReportView {
//    override fun onListFragmentInteraction(item: Penjualan?) {
//
//    }

    private lateinit var presenter: ReportPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        cekSesi(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        presenter = ReportPresenter(this)
        presenter.getReportAll(user?.idUser)
    }

    override fun onSuccessReport(keranjang: List<Keranjang?>?) {
        rvReport.adapter = ReportAdapter(keranjang, object : ReportAdapter.OnClick {
            override fun click(keranjang: Keranjang?, position: Int) {
                val bundle = Bundle()
                bundle.putSerializable("penjualan", keranjang)

                val detailReportFragment = DetailReportFragment()
                detailReportFragment.arguments = bundle

                detailReportFragment.show(supportFragmentManager, "Report")
            }

            override fun restore(keranjang: Keranjang?) {
                presenter.restoreStatus(user?.idUser, Integer.parseInt(keranjang?.idKeranjang),
                    KeranjangStatus.PENDING.status, Integer.parseInt(keranjang?.qty), keranjang?.totalHarga)
            }
        })
    }

    override fun onFailedReport(localizedMessage: String?) {
        if (localizedMessage != null) {
            Log.d("ReportActivity", localizedMessage)
        }
    }

    override fun onSuccessRestore(msg: String?) {
        toast("Berhasil membatalkan penjualan").show()
        presenter.getReportAll(user?.idUser)
    }

    override fun onFailedRestore(msg: String?) {
        if (msg != null) {
            Log.d("ReportActivity", msg)
        }
    }

}
package com.backend.practica10.demo.service

import com.backend.practica10.demo.model.Mmascota
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.util.ResourceUtils
import java.io.File
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import javax.servlet.http.HttpServletResponse

@Service("generateReportService")
class generateReportService {

    @Autowired
    @Qualifier("mascotaService")
    private lateinit var mascotaService: mascotaService;

    private var path : String = "C:\\Users\\Ac-04\\Desktop";

    fun exportReport(response: HttpServletResponse) {

        var mascotas: List<Mmascota> = mascotaService.obtenerMascotas();

        var file: File = ResourceUtils.getFile("classpath:mascotas.jrxml")

        var jasperReport: JasperReport = JasperCompileManager.compileReport(file.absolutePath)
        var dataSource: JRBeanCollectionDataSource = JRBeanCollectionDataSource(mascotas);
        val parameters = hashMapOf<String, Any>()

        parameters.put("createdBy", "veterinaria")

        var jasperPrint: JasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        JasperExportManager.exportReportToPdfStream(jasperPrint, response.outputStream);
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");
    }

}

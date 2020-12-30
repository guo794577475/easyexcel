package com.example.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.vo.TitileVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/download")
public class DownloadController {

    @RequestMapping("/hi")
    private String hi(){
        return "hi";
    }
    @RequestMapping("/export")
    private void export(HttpServletResponse response) throws IOException {
        System.out.println("begin export");
        Long fileName = System.currentTimeMillis();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        // excel头策略
        /*WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short) 11);
        headWriteFont.setBold(false);
        headWriteCellStyle.setWriteFont(headWriteFont);
        // excel内容策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        WriteFont contentWriteFont = new WriteFont();
        contentWriteFont.setFontHeightInPoints((short)11);
        contentWriteCellStyle.setWriteFont(contentWriteFont);*/
        // 设置handler
//        HorizontalCellStyleStrategy styleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);

        EasyExcel.write(response.getOutputStream(), TitileVO.class)
                .sheet("下载excel服务")
//                .registerWriteHandler(styleStrategy)
                .doWrite(data());
        Long time = System.currentTimeMillis();
        System.out.println(time-fileName);
    }
    @RequestMapping("/yuque")
    private void yuque(){
        System.out.println("yuque begin");
        String fileName = System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, TitileVO.class).sheet("模板").doWrite(data());
        System.out.println("yuque end");
    }

    private List<TitileVO> data() {
        List<TitileVO> titileVOS = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            TitileVO titileVO = new TitileVO();
            titileVO.setAddress("光浩国际中心" + i);
            titileVO.setAge(10+i);
            titileVO.setEmail(i + "" + i + "0@qq.com");
            titileVO.setId(i);
            titileVO.setName("name" +i);
            titileVO.setPhoneNo("1303446" + i);
            titileVOS.add(titileVO);
            if (i%1000==0){
                System.out.println("" + i);
            }
        }
        return titileVOS;
    }
}

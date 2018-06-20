package com.xdht.disease.shunfeng.controller;

import com.sf.csim.express.service.CallExpressServiceTools;
import com.xdht.disease.shunfeng.model.Order;
import com.xdht.disease.shunfeng.model.SfExpressResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Log4j
@RestController
@RequestMapping(value = "/api/v1/sf")
public class SfController {
    String reqURL = "http://bsp-oisp.sf-express.com/bsp-oisp/sfexpressService";
    String reqXml = "";
    String clientCode = "feng";
    String checkword = "4vIhSb7jDzToFIPgmNpmwz4Bajo4upZU";

    @RequestMapping(value = "/order", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "下单")
    public SfExpressResponse order(Order orderInfo){

        //
        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append("<Request service='OrderService' lang='zh-CN'>");
        strBuilder.append("<Head>"+clientCode+"</Head>");
        strBuilder.append("<Body>");
        strBuilder.append("<Order").append(" ");
        strBuilder.append("orderid='"+orderInfo.getOrderId()+"' ").append(" ");
        //寄件人信息
        strBuilder.append("j_province='" + orderInfo.getjProvince() + "'").append(" ");
        strBuilder.append("j_city='" + orderInfo.getjCity() + "'").append(" ");
        strBuilder.append("j_county='" + orderInfo.getjCounty() + "'").append(" ");
        strBuilder.append("j_company='" + orderInfo.getjCompany() + "'").append(" ");
        strBuilder.append("j_contact='" + orderInfo.getjContact() + "'").append(" ");
        strBuilder.append("j_tel='" + orderInfo.getjTel() + "'").append(" ");
        strBuilder.append("j_address='" + orderInfo.getjAddress() + "'").append(" ");
        //收件人信息
        strBuilder.append("d_province='" + orderInfo.getdProvince() + "'").append(" ");
        strBuilder.append("d_city='" + orderInfo.getdCity() + "'").append(" ");
        strBuilder.append("d_county='" + orderInfo.getdCounty() + "'").append(" ");
        strBuilder.append("d_company='" + orderInfo.getdCompany() + "'").append(" ");
        strBuilder.append("d_contact='" + orderInfo.getdContact() + "'").append(" ");
        strBuilder.append("d_tel='" + orderInfo.getdTel() + "'").append(" ");
        strBuilder.append("d_address='" + orderInfo.getjProvince() + orderInfo.getjCity() + orderInfo.getjCounty() + orderInfo.getdAddress() + "'").append(" ");
        strBuilder.append(" > ");

        //货物信息
        strBuilder.append("<Cargo").append(" ");
        strBuilder.append("name='" + orderInfo.getName() + "'").append(" ");
        strBuilder.append("count='" + orderInfo.getCount() + "'").append(" ");
        strBuilder.append("unit='" + orderInfo.getUnit() + "'").append(">");
        strBuilder.append("</Cargo>");
        //
        strBuilder.append("</Order>");
        strBuilder.append("</Body>");
        strBuilder.append("</Request>");
        reqXml = strBuilder.toString();
        CallExpressServiceTools client=CallExpressServiceTools.getInstance();
        String respxml = client.callSfExpressServiceByCSIM(reqURL,reqXml,clientCode,checkword);
        SfExpressResponse sf = null;
        try {
            JAXBContext context = JAXBContext.newInstance(SfExpressResponse.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            sf = (SfExpressResponse)unmarshaller.unmarshal(new StringReader(respxml));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sf;
    }

    @RequestMapping(value = "/ordersearch", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "订单结果查询")
    public SfExpressResponse orderSearch(Order orderInfo){

        //
        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append("<Request service='OrderSearchService' lang='zh-CN'>");
        strBuilder.append("<Head>"+clientCode+"</Head>");
        strBuilder.append("<Body>");
        strBuilder.append("<OrderSearch").append(" ");
        strBuilder.append("orderid='QIAO-20180104005'/>");
        strBuilder.append("</Body>");
        strBuilder.append("</Request>");
        reqXml = strBuilder.toString();
        CallExpressServiceTools client=CallExpressServiceTools.getInstance();
        String respxml = client.callSfExpressServiceByCSIM(reqURL,reqXml,clientCode,checkword);
        SfExpressResponse sf = null;
        try {
            JAXBContext context = JAXBContext.newInstance(SfExpressResponse.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            sf = (SfExpressResponse)unmarshaller.unmarshal(new StringReader(respxml));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sf;
    }

    @RequestMapping(value = "/orderConfirm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "订单确认/取消")
    public SfExpressResponse orderConfirm(Order orderInfo){

        //
        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append("<Request service='OrderConfirmService' lang='zh-CN'>");
        strBuilder.append("<Head>"+clientCode+"</Head>");
        strBuilder.append("<Body>");
        strBuilder.append("<OrderConfirm").append(" ");
        strBuilder.append("orderid='QIAO-20180104005'").append(" ");
        strBuilder.append("dealtype='2'>");
        strBuilder.append("</OrderConfirm>");
        strBuilder.append("</Body>");
        strBuilder.append("</Request>");
        reqXml = strBuilder.toString();
        CallExpressServiceTools client=CallExpressServiceTools.getInstance();
        String respxml = client.callSfExpressServiceByCSIM(reqURL,reqXml,clientCode,checkword);
        SfExpressResponse sf = null;
        try {
            JAXBContext context = JAXBContext.newInstance(SfExpressResponse.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            sf = (SfExpressResponse)unmarshaller.unmarshal(new StringReader(respxml));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sf;
    }

    @RequestMapping(value = "/routeInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "物流信息")
    public SfExpressResponse RouteInfo(Order orderInfo){

        //
        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append("<Request service='RouteService' lang='zh-CN'>");
        strBuilder.append("<Head>"+clientCode+"</Head>");
        strBuilder.append("<Body>");
        strBuilder.append("<RouteRequest").append(" ");
        strBuilder.append("tracking_type='2'").append(" ");
        strBuilder.append("method_type='1'").append(" ");
        strBuilder.append("tracking_number='QIAO-20180104005'/>");
        strBuilder.append("</Body>");
        strBuilder.append("</Request>");
        reqXml = strBuilder.toString();
        CallExpressServiceTools client=CallExpressServiceTools.getInstance();
        String respxml = client.callSfExpressServiceByCSIM(reqURL,reqXml,clientCode,checkword);
        SfExpressResponse sf = null;
        try {
            JAXBContext context = JAXBContext.newInstance(SfExpressResponse.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            sf = (SfExpressResponse)unmarshaller.unmarshal(new StringReader(respxml));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sf;
    }


}
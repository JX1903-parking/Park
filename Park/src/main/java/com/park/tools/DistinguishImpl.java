package com.park.tools;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import com.tencentcloudapi.ocr.v20181119.models.LicensePlateOCRRequest;
import com.tencentcloudapi.ocr.v20181119.models.LicensePlateOCRResponse;
import org.springframework.stereotype.Repository;

@Repository("distinguish")
public class DistinguishImpl implements Distinguish {
    @Override
    public LicensePlateOCRResponse distinguish(String img) {
        LicensePlateOCRResponse resp = null;
        try {
            System.out.println("jin");
//            String imgFile =img; // 待处理的图片
            String imgbese = Img2Base64Util.getImgStr(img);
            System.out.println("-----99");
//            String imgFilePath = img;// 新生成的图片
            Img2Base64Util.generateImage(imgbese, img);
            System.out.println(imgbese+"=========");
            Credential cred = new Credential("AKIDGLBnBLEwNYUAbmLO2VjiU2MSJzRdeGiv", "COLK9mAWfaGQWNzPaVEiwve8Ns9E4f17");
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("ocr.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            OcrClient client = new OcrClient(cred, "ap-beijing", clientProfile);
            String params = "{\"ImageBase64\":\""+imgbese+"\"}";
            LicensePlateOCRRequest req = LicensePlateOCRRequest.fromJsonString(params, LicensePlateOCRRequest.class);
            resp = client.LicensePlateOCR(req);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return resp;
    }
}

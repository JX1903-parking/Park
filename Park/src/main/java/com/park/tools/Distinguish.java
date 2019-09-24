package com.park.tools;

import com.tencentcloudapi.ocr.v20181119.models.LicensePlateOCRResponse;

public interface Distinguish {
    public LicensePlateOCRResponse distinguish(String img);
}

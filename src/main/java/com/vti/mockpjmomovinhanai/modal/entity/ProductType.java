package com.vti.mockpjmomovinhanai.modal.entity;

public enum ProductType  {
    VTE ("Vì Trẻ Em"),
    NGNKT("Người Già, Người Khuyết Tật"),
    BHN("Bệnh Hiểm Nghèo"),
    HCKK("Hoàn Cảnh Khó Khăn"),
    HTGD("Hỗ Trợ Giáo Dục"),
    DTCSVC("Đầu Tư Cơ Sở Vật Chất"),
    CTDV("Cứu Trợ Động Vật"),
    BVMT("Bảo Vệ Môi Trường");
    public final String productType;

    ProductType(String productType) {
        this.productType = productType;
    }
}

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

    public String getProductType() {
        return productType;
    }

    ProductType(String productType) {
        this.productType = productType;
    }

    public static String convertToProductType(String value) {
        for (ProductType productType : ProductType.values()) {
            if (productType.getProductType().equals(value)) {
                return productType.name();
            }
        }
        return null; // Giá trị default khi ko có trường hợp đúng
    }
}

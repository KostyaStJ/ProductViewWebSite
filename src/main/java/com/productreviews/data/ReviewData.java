package com.productreviews.data;

import lombok.Data;

@Data
public class ReviewData {
    private Integer reviewId;
    private Integer productId;
    private String text;
}

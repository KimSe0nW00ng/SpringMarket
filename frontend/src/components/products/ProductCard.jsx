import { Card, CardContent, CardMedia, Typography } from "@mui/material";
import React from "react";

const ProductCard = () => {
  return (
    <Card sx={{ maxWidth: 345 }}>
      <CardMedia
        sx={{ height: 140 }}
        image="https://img.danawa.com/prod_img/500000/534/217/img/11217534_1.jpg?shrink=330:330&_v=20211026161925"
        title="green iguana"
      />
      <CardContent>
        <Typography gutterBottom variant="h6" component="div">
          상품이름
        </Typography>
        <Typography variant="h6" sx={{ fontWeight: "bold" }}>
          10,000원
        </Typography>
        {/* <Typography variant="body2" color="text.secondary">
          구매수 1
        </Typography> */}
      </CardContent>
    </Card>
  );
};

export default ProductCard;

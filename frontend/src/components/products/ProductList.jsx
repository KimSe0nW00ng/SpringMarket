import { Box, Container, Grid, Typography } from "@mui/material";
import React from "react";
import ProductCard from "./ProductCard";

const ProductList = () => {
  return (
    <Box mb={2}>
      <Container maxWidth="lg">
        <Typography variant="h5" mt={2} mb={2} sx={{ fontWeight: "bold" }}>
          인기상품
        </Typography>
        <Grid
          container
          spacing={{ xs: 2, md: 3 }}
          columns={{ xs: 4, sm: 8, md: 12 }}
        >
          {Array.from(Array(6)).map((_, index) => (
            <Grid item xs={2} sm={4} md={4} key={index}>
              <ProductCard />
            </Grid>
          ))}
        </Grid>
      </Container>
    </Box>
  );
};

export default ProductList;

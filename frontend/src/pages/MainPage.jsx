import axios from "axios";
import React, { useState } from "react";
import Banner from "../components/Banner";
import ProductList from "../components/products/ProductList";

const MainPage = () => {
  return (
    <>
      <Banner />
      <ProductList />
    </>
  );
};

export default MainPage;

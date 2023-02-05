import axios from "axios";
import React, { useState } from "react";
import Footer from "../components/layouts/Footer";
import Header from "../components/layouts/Header";

const MainPage = () => {
  const [test, setTest] = useState("");

  const getTest = async () => {
    await axios
      .get("http://localhost:3000/api/v1/test")
      .then((res) => {
        console.log(res);
        setTest("Test " + res.data.test);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <>
      <Header />
      <div>{test}</div>
      <button onClick={getTest}>클릭</button>
      <Footer />
    </>
  );
};

export default MainPage;

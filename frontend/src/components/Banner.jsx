import React from "react";
import { Carousel } from "react-responsive-carousel";

const CarouselBanner = () => {
  return (
    <Carousel showThumbs={false} showIndicators={false} showStatus={false}>
      <div>
        <img src="assets/banner.jpg" />
      </div>
    </Carousel>
  );
};

export default CarouselBanner;

import { Box, Container, Typography } from "@mui/material";
import React from "react";

const Footer = () => {
  return (
    <Box
      component="footer"
      sx={{ bgcolor: "background.paper", py: 6, borderTop: "1px solid gray" }}
    >
      <Container maxWidth="lg">
        <Typography variant="h6" align="center" gutterBottom>
          SpringMarket
        </Typography>
      </Container>
    </Box>
  );
};

export default Footer;

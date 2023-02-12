import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import LocalGroceryStoreIcon from "@mui/icons-material/LocalGroceryStore";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";
import { Link as RouterLink } from "react-router-dom";

const Header = () => {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar
        position="static"
        sx={{ backgroundColor: "white", color: "black" }}
      >
        <Toolbar>
          <Box
            sx={{
              flexGrow: 1,
              display: { xs: "flex", md: "flex" },
            }}
          >
            <Typography
              variant="h6"
              sx={{
                fontWeight: "bold",
                letterSpacing: ".1rem",
                color: "inherit",
                textDecoration: "none",
                fontFamily: "monospace",
              }}
              component="a"
              href="/"
            >
              SpringMarket
            </Typography>
          </Box>
          <Button component={RouterLink} to="/login" color="inherit">
            로그인
          </Button>
          <Button component={RouterLink} to="/signup" color="inherit">
            회원가입
          </Button>
          {/* <AccountCircleIcon />
          <Button color="inherit">로그아웃</Button> */}
          <Button component={RouterLink} color="inherit" to="/cart">
            <LocalGroceryStoreIcon />
          </Button>
        </Toolbar>
      </AppBar>
    </Box>
  );
};

export default Header;

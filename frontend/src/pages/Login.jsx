import React, { useState } from "react";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import axios from "axios";

const theme = createTheme();

const Login = () => {
  const [memberId, setMemberId] = useState("");
  const [memberPassword, setMemberPassword] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (memberId === "") {
      alert("아이디를 입력해주세요");
      return;
    }

    if (memberPassword === "") {
      alert("비밀번호를 입력해주세요");
      return;
    }

    await axios
      .post("http://localhost:3000/login", {
        member_id: memberId,
        member_password: memberPassword,
      })
      .then((res) => {
        console.log(res.headers.authorization);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <ThemeProvider theme={theme}>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 8,
            marginBottom: 8,
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
          }}
        >
          <Typography component="h1" variant="h5">
            로그인
          </Typography>
          <Box
            component="form"
            onSubmit={handleSubmit}
            noValidate
            sx={{ mt: 1 }}
          >
            <TextField
              margin="normal"
              required
              fullWidth
              id="memberId"
              label="아이디"
              name="memberId"
              autoFocus
              onChange={(e) => {
                setMemberId(e.target.value);
              }}
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="memberPassword"
              label="비밀번호"
              type="password"
              id="memberPassword"
              onChange={(e) => {
                setMemberPassword(e.target.value);
              }}
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
            >
              로그인
            </Button>
          </Box>
        </Box>
      </Container>
    </ThemeProvider>
  );
};

export default Login;

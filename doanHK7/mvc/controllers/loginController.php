<?php
    class loginController extends controller{
        public function login()
	{	
        $this->view('loginView');

		$username = $password = $fullName = NULL;
		$error = array();
		$error['username'] = $error['password'] = NULL;

		if (empty($_POST['login'])) {
			if (empty($_POST['username'])) {
				$error['username'] = '* Cần điền tên đăng nhập';
			} else {
				$username = $_POST['username'];
			}
			if (empty($_POST['password'])) {
				$error['password'] = '* Cần điền mật khẩu';
			} else {
				// $password = md5(md5($_POST['password']));
				$password = $_POST['password'];
			}

			if ($username && $password) {
                $result = $this->model("usermodel")->login($username,$password);
				$check = $result->num_rows; /*đếm số dòng trong database*/
			/**
		    * Nếu số dòng trong database > 0 => lưu session + lấy dữ liệu + chuyển hướng
		    * Ngược lại thông báo alert bằng script
		    * @var array
		    */
				if ($check > 0) {
					$data = $result->fetch_array(); /*lấy dữ liệu tương ứng với username và password nhập*/
					$_SESSION['login'] = $data; /*lưu session*/
					header('Location: http://localhost/doan3/home/getProduct');
				} else {
					echo "<script>alert('Sai mật khẩu hoặc tên đăng nhập')</script>";
				}
			}
		}

		return $error;
	}
    }

?>
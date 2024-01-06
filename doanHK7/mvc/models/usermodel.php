<?php
    class usermodel extends db{
        public function login($username, $password)
	{
		$sql = "SELECT * FROM taikhoan WHERE tentk = '$username' AND matkhau = '$password'";
		// $result = $this->db->conn->query($sql);
		$result = mysqli_query($this->conn, $sql);
		return $result;
	}
    }
?>
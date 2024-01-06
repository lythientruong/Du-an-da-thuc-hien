<?php
    class admin extends controller{
        function getProduct(){
            $product = $this->model("productModel");
            $this->view("navbar",
            ["danhmucsanpham"=>$product->getDanhmucsanpham()]);
            $this->view("homePage",
            [ "pages"=>"adminView"
                ,"sanpham"=>$product->getProduct()]);
        }

        function adminAddProduct(){
            $product = $this->model("productModel");
            $this->view("navbar",
            ["danhmucsanpham"=>$product->getDanhmucsanpham()]);
            $this->view("homePage",["pages"=>"adminAddProduct"]);
            if(empty($_POST['themsp'])){
                $tensp = $_POST['tensp'];
                $giaban = $_POST['giaban'];
                $chitiet = $_POST['chitiet'];
                $hinhanh = $_POST['hinhanh'];
                $soluong = $_POST['soluong'];
                $maloai = $_POST['maloai'];
                $math = $_POST['math'];

                $this->model("cartProductModel")->adminAddProduct($tensp,$giaban,$chitiet,$hinhanh,$soluong,$maloai,$math);
            }
        }

        function delete(){
            $id = $_GET['id'];
            $this->model("cartProductModel")->adminDelete($id);

            $product = $this->model("productModel");
            $this->view("navbar",
            ["danhmucsanpham"=>$product->getDanhmucsanpham()]);
            $this->view("homePage",
            [ "pages"=>"adminView"
            ,"sanpham"=>$product->getProduct()]);
        }


    }

?>
<?php
    class home extends controller{
        // function getTour(){
        //     $product = $this->model("productModel");
        //     $this->view("navbar");
        //     $this->view("homePage");
        // }
        function getTour(){
            $product = $this->model("tourModel");
            $this->view("homePage",
            [ "pages"=>"tourInfor"
            ,"tour"=>$product->getTour()]);
            $this->view("navbar",
            ["province"=>$product->getProvince()],"nav");
            
        }

        function detailTour(){
            $id = $_GET['idTour'];
            $product = $this->model("tourModel");
            $this->view("navbar");
            $this->view("homePage",
            [ "pages"=>"detailTour"
                ,"tour"=>$product->getdetailTour($id)]);              
        }

        function getProvince(){
            $product = $this->model("tourModel"); 
            $this->view("homePage",
            [ "pages"=>"tourInfor"
            ,"tour"=>$product->getTour()]);
            $this->view("navbar",
            ["province"=>$product->getProvince()]);
            echo $product;
        }


        function getProduct_loai(){
            $product = $this->model("tourModel");
            $this->view("navbar",
            ["danhmucsanpham"=>$product->getDanhmucsanpham()]);
           $loai = $_GET['id'];
            $this->view("homePage",
            [ "pages"=>"productInfor"
                ,"sanpham"=>$product->getProduct_loai($loai),
            ]);
           
        }

        function getDetailProduct(){
            $product = $this->model("tourModel");
            $this->view("navbar",
            ["danhmucsanpham"=>$product->getDanhmucsanpham()]);
            $a = $product->editProduct();
            $this->view(
                "homePage",
                ["pages"=>"productInfor",
                "Key"=>$a]);
        }

        function search(){
            $search = $this->model("tourModel");
            $this->view("navbar",
            ["danhmucsanpham"=>$search->getDanhmucsanpham()]);
            $this->view(
            "homePage",
            ["pages"=>"productInfor", 
            "sanpham"=>$search->search()]
            );
        }

        function addProduct_to_cart(){
            $product = $this->model("tourModel");
            $this->view("navbar",
            ["danhmucsanpham"=>$product->getDanhmucsanpham()]);
            $this->view("homePage",
            [ "pages"=>"cartProductView"
                ,"sanpham"=>$product->getProduct()]);
        }

        function xemdsdonhang(){
            $product = $this->model("tourModel");
            $arr = $product->xemdonhang();
            $this->view("navbar",
            ["danhmucsanpham"=>$product->getDanhmucsanpham()]);
            $this->view(
                "homePage",
                ["pages"=>"dsdonhang", 
                "donhang"=>$product->xemdonhang()]
                );
        }

        function addToCart(){
            $id = $_GET['id'];
         
            $product = $this->model("tourModel");
            $arr = $product->getProducttocart($id);
            while($row = mysqli_fetch_array($arr)){
                $tensp = $row['tensp'];
                $gia = $row['giaban'];
            }


            $product->addToCart($id,$tensp,$gia);
            header("Location: http://localhost/doan3/home/getProduct");
        }

        function xemgiohang(){
            $product = $this->model("tourModel");
            $this->view("navbar",
            ["danhmucsanpham"=>$product->getDanhmucsanpham()]);
            $this->view("homePage",
            [ "pages"=>"giohang"
                ,"giohang"=>$product->getProductforGiohang()]);
        }

        function xoaspgiohang(){
            $id = $_GET['id'];
            $product = $this->model("productModel");
            $product->xoaspgiohang($id);
            header("Location: http://localhost/doan3/home/xemgiohang");       
        }


        
    }
?>


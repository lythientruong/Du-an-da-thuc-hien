<?php
    class controller{
        public function model($model){
            require_once "./mvc/models/".$model.".php";
            return new $model;

        }

        public function view($view, $data=[], $param="navbar"){
            require_once "./mvc/views/".$view.".php";
        }

        public function log_out(){
            session_destroy();
            header('Location: http://localhost/doan3/loginController/login');
        }


    }


?>
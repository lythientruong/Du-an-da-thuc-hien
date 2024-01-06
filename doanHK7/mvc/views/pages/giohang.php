<table class="table">
    
  <thead>
    <tr>
    <th scope="col">Mã SP</th>
      <th scope="col">Tên SP</th>
      <th scope="col">Số lượng</th>
      <th scope="col">Giá</th>
    </tr>
  </thead>
  <tbody>
    <?php
        while($row = mysqli_fetch_array($data["giohang"])){
    ?>
    <tr>
      <th scope="row"><?php echo $row['masp']; ?></th>
      <td><?php echo $row['tensp']; ?></td>
      <td><?php echo $row['soluong']; ?></td>
      <td><?php echo $row['giaban']; ?></td>
      <td><button><a href="http://localhost/doan3/home/xoaspgiohang&id=<?php  echo $row['masp']; ?>">Xóa</a></button></td>
    </tr>
    <?php } ?>
    
  </tbody>

</table>
<footer class="d-flex justify-content-end">
<button class="m-4"><a href="http://localhost/doan3/home/xemdsdonhang">Xem đơn hàng đã thanh toán</a></button>
<button class="m-4"><a href="http://localhost/doan3/home/getProduct">Thanh toán</a></button>
</footer>
  
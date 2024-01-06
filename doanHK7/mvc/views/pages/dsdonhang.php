<table class="table">
    
  <thead>
    <tr>
      <th scope="col">Mã đơn hàng</th>
      <th scope="col">Giá tiền</th>
      <th scope="col">Ngày xuất đơn hàng</th>
      <th scope="col">Địa chỉ đơn hàng</th>
      <th scope="col">Số điện thoại</th>
      <th scope="col">Trạng thái đơn hàng</th>
    </tr>
  </thead>
  <tbody>
    <?php
        while($row = mysqli_fetch_array($data["donhang"])){
    ?>
    <tr>
      <th scope="row"><?php echo $row['madh']; ?></th>
      <td><?php echo $row['giatridh']; ?></td>
      <td><?php echo $row['ngayxuatdh']; ?></td>
      <td><?php echo $row['diachinhanhang']; ?></td>
      <td><?php echo $row['sdt']; ?></td>
      <td><?php $row['trangthaidh']; 
        if($row['trangthaidh'] == 1){
          echo "Đã thanh toán";
        }else{
          echo "Chưa thanh toán";
        }
      ?></td>
    </tr>
    <?php } ?>
  </tbody>
</table>
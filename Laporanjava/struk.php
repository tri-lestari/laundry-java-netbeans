<?php 
include "config/koneksi.php";
?>
<form method="post">
<table border="1" align="center">
  <tr>
    <td>
      <div class="utama">
		<table align="center">
      		<tr>
        		
        		<td width="93%" valign="top">&nbsp; LAUNDRY</td>
      		</tr>
      		<tr>
       			<td valign="top">Jl. Warung Gantung, Jakarta</td>
      		</tr>
    	</table>
    	<table width="100%">
      	<tr><td><hr></td></tr>
    	</table>
  		<table cellspacing="0">  
  		<?php @$sql = "SELECT * FROM tbl_ambil where no_antrian = '$_GET[id]'";
		      $query = mysqli_query($con,$sql);
		      $row = mysqli_fetch_array($query)	
		 ?>
		<tr>
			<td>Nama      </td><td>: </td><td> <?php echo $row['nama']?></td>
		</tr>
		<tr>
      		<td>Tanggal     </td><td>: </td><td> Rp.<?php echo $row['tanggal']; ?></td>
     	</tr>
      	<tr>
      		<td>Total </td><td>: </td><td> Rp.<?php echo $row['total']; ?></td>
      	</tr>
        <tr>
          <td>Bayar </td><td>: </td><td> Rp.<?php echo $row['bayar']; ?></td>
        </tr>
        <tr>
          <td>Kembalian </td><td>: </td><td> Rp.<?php echo $row['kembali']; ?></td>
        </tr>
    	<table  width="100%">
      		<tr><td><hr></td></tr>
      		<tr><td><center> SELAMAT DATANG KEMBALI </center><hr></td></tr>
    	</table>
    	<table align="center">
      		<tr>
        		<td>&copy; <?php echo date('Y'); ?> LAUNDRY</td>
      		</tr>
    	</table>
	</div>
    </td>
  </tr>
</table>
</form>


<script type="text/javascript">
  window.onload=function(){
  window.print();
}
</script> 
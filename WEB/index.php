<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./css/estils.css">
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <title>Inici</title>

</head>

<body>
    <div id="all">
        <header>
<!--Aqui tenim un menu que va a la taula del producte que fem clic-->
            <nav>
                <ul>
                    <img src="./img/logo.png" alt="Logo">
                    <li><a href="#esquis">Esquis</a></li>
                    <li><a href="#botes">Botes</a></li>
                    <li><a href="#bastons">Bastons</a></li>
                </ul>
            </nav>
            <div id="baixa">
                <h1>Productes Disponibles</h1>
            </div>
        </header>
        <section>
<!--Aqui hem afegit un buscador fet amb javascript-->
            <div class="input-group">
                <input id="entradafilter" type="text" class="form-control">
            </div>
            <table id="esquis" border="1" class="table table-striped">
                <caption>Esquis</caption>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Talla</th>
                        <th>Preu</th>
                    </tr>
                </thead>
                <tbody class="contenidobusqueda">
                    <?php 
                    //En aquesta apartat tenim el codi de la conexio a BBDD
                        $con = mysqli_connect("localhost", "root", "", "alquiler");
                        if($con === false){
                            die("ERROR: Could not connect. " . mysqli_connect_error());
                        }
                        if($con){
                            //Aqui fem el select de la taula Esquis de la BBDD
                            $sql = "SELECT * FROM esquis";
                            $result = mysqli_query($con, $sql);
                            //I aqui impremim el resultat del select en la pagina web
                            while ($esqui = mysqli_fetch_array($result)){
                                echo"
                                <tr>
                                    <td>".$esqui['ID']."</td>
                                    <td>".$esqui['Nom']."</td>
                                    <td>".$esqui['Talla']."</td>
                                    <td>".$esqui['Preu']." €</td>
                                </tr>
                                ";
                            }
                        }
                        //Tanquem la connexio amb la BBDD
                        mysqli_close($con);
                    ?>
                </tbody>
            </table>
            <table id="botes" border="1" class="table table-striped">
                <caption>Botes</caption>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Talla</th>
                        <th>Preu</th>
                    </tr>
                </thead>
                <tbody class="contenidobusqueda">
                    <?php
                    //En aquesta apartat tenim el codi de la conexio a BBDD
                    $con = mysqli_connect("localhost", "root", "", "alquiler");
                        if($con === false){
                            die("ERROR: Could not connect. " . mysqli_connect_error());
                        }
                    if($con){
                        //Aqui fem el select de la taula Botes de la BBDD
                        $sql = "SELECT * FROM botes";
                        $result = mysqli_query($con, $sql);
                        //I aqui impremim el resultat del select en la pagina web
                        while ($bota = mysqli_fetch_array($result)){
                            echo"
                            <tr>
                                <td>".$bota['ID']."</td>
                                <td>".$bota['Nom']."</td>
                                <td>".$bota['Talla']."</td>
                                <td>".$bota['Preu']." €</td>
                            </tr>
                            ";
                        }
                    }
                        //Tanquem la connexio amb la BBDD
                        mysqli_close($con);
                    ?>
                </tbody>
            </table>
            <table id="bastons" border="1" class="table table-striped">
                <caption>Bastons</caption>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Talla</th>
                        <th>Preu</th>
                    </tr>
                </thead>
                <tbody class="contenidobusqueda">
                    <?php
                    //En aquesta apartat tenim el codi de la conexio a BBDD
                        $con = mysqli_connect("localhost", "root", "", "alquiler");
                            if($con === false){
                                die("ERROR: Could not connect. " . mysqli_connect_error());
                            }
                        if($con){
                            //Aqui fem el select de la taula Pals de la BBDD
                            $sql = "SELECT * FROM bastones";
                            $result = mysqli_query($con, $sql);
                            //I aqui impremim el resultat del select en la pagina web
                            while ($pal = mysqli_fetch_array($result)){
                                echo"
                                <tr>
                                    <td>".$pal['ID']."</td>
                                    <td>".$pal['Nom']."</td>
                                    <td>".$pal['Talla']."</td>
                                    <td>".$pal['Preu']." €</td>
                                </tr>
                                ";
                            }
                        }
                        //Tanquem la connexio amb la BBDD
                        mysqli_close($con);
                    ?>
                </tbody>
            </table>
        </section>
        <footer>
            <a href="#" class="fa fa-facebook"></a>
            <a href="#" class="fa fa-twitter"></a>
            <a href="#" class="fa fa-instagram"></a>
            <a href="#" class="fa fa-youtube"></a>
        </footer>
    </div>
</body>
<script>
    //Aqui tenim el codi de la bara de busqueda
    $(document).ready(function() {
        $('#entradafilter').keyup(function() {
            var rex = new RegExp($(this).val(), 'i');
            $('.contenidobusqueda tr').hide();
            $('.contenidobusqueda tr').filter(function() {
                return rex.test($(this).text());
            }).show();

        })

    });

</script>

</html>

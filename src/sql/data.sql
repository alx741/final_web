/* ********************************
 *  Datos generados aleatoreamente
 *
 *  Password: 12345
 * ********************************/


USE `paqueteria`,

/* Empleados */
DELETE FROM `empleados`;
INSERT INTO `empleados` (`id_empleado`,`cedula`,`nombre`,`password`) VALUES
(1,"164906015","Xaviera Hall", "12345"),
(2,"165708077","Olympia Mccall", "12345"),
(3,"162012249","Zachary Petty", "12345"),
(4,"163508236","Kai Garza", "12345"),
(5,"168807169","Wallace Trujillo", "12345"),
(6,"166608194","Uriel Howe", "12345"),
(7,"167209039","Amity Huffman", "12345"),
(8,"163806073","Yvonne England", "12345"),
(9,"169101153","Lamar Mcclure", "12345"),
(10,"169207079","Urielle Brock", "12345"),
(11,"166408253","Phelan Lamb", "12345"),
(12,"162303238","Coby Meyers", "12345"),
(13,"163404297","Daria Henderson", "12345"),
(14,"160606213","Tucker Garza", "12345"),
(15,"166206035","Xena Rivers", "12345"),
(16,"169304188","Isaac Waller", "12345"),
(17,"160907022","Kaitlin Jenkins", "12345"),
(18,"168410061","Kiayada Strong", "12345"),
(19,"167104258","Ryan Bruce", "12345"),
(20,"166309031","Noble Santana", "12345");



/* Clientes */
DELETE FROM `clientes`;
INSERT INTO `clientes` (`id_cliente`,`ruc_empresa`,`nombre_empresa`,
    `cedula_representante`,`nombre_representante`,`telefono`,
    `direccion`,`password`) VALUES
(1,"19840494","Penatibus Et Corporation","391610771","Olivia Hendrix","2 773 255","Ap #349-209 Commodo St.","12345"),
(2,"36331567","Tincidunt Tempus Associates","377579529","Melyssa Estes","2 269 437","7047 Libero Avenue","12345"),
(3,"39378816","Vitae Sodales LLC","648220283","Ryder Soto","2 442 044","Ap #648-1051 Nunc St.","12345"),
(4,"19609804","Mauris Elit Dictum Associates","589162957","Vernon Foreman","2 307 437","3644 Ligula. St.","12345"),
(5,"29981825","Malesuada Fames Inc.","837365220","Illiana Ray","2 227 375","569-1166 Convallis Avenue","12345"),
(6,"27310124","Hymenaeos Mauris Ut Company","097174338","Griffin Massey","2 061 105","P.O. Box 232, 5185 Nam Ave","12345"),
(7,"16029328","Phasellus Dapibus Quam Limited","830723292","Oprah Gibson","2 020 120","Ap #880-3475 Fermentum St.","12345"),
(8,"30525236","Lacus LLC","126114891","Deacon Lewis","2 508 240","491-3554 Adipiscing Rd.","12345"),
(9,"31482055","Gravida Nunc Sed Incorporated","929825560","Candace Short","2 043 635","P.O. Box 561, 7578 Vel, Ave","12345"),
(10,"11161060","Blandit Enim Company","148733249","Chester Molina","2 446 848","5378 Urna Rd.","12345"),
(11,"19088589","Lacinia Sed Associates","060500501","Felicia Gross","2 690 164","P.O. Box 542, 7739 Nam Ave","12345"),
(12,"23990147","Lectus Convallis Est Inc.","176771640","Cameron Jensen","2 734 626","Ap #213-6269 Ante Ave","12345"),
(13,"7913637","Magna Ut Inc.","338747082","Mira Dawson","2 134 517","5129 Lacus. Ave","12345"),
(14,"15066919","Cursus Vestibulum Inc.","144151131","Armando Buckner","2 321 094","Ap #661-4355 Egestas. St.","12345"),
(15,"33421173","Facilisis Facilisis Magna Corp.","039321419","Abigail Petty","2 616 657","P.O. Box 308, 6638 Sapien St.","12345"),
(16,"14625342","Vehicula Aliquet Consulting","257140921","Emery Emerson","2 216 842","6317 In St.","12345"),
(17,"30611768","Fusce Aliquet Magna Foundation","449827690","Colette Mitchell","2 568 886","P.O. Box 978, 9966 Iaculis Rd.","12345"),
(18,"15633897","Elit Pharetra Ut Associates","065164709","Ava Mays","2 480 412","220-4938 Cum Rd.","12345"),
(19,"44641443","Vulputate Ltd","446385189","Vivien Robles","2 742 371","P.O. Box 193, 7829 Sapien. Avenue","12345"),
(20,"48295602","Vitae Incorporated","659868822","Whilemina Aguilar","2 649 181","305-9887 Tincidunt Rd.","12345"),
(21,"36964260","Mauris Ut LLP","211518980","Lance Wolf","2 769 866","Ap #227-8723 Magna. Avenue","12345"),
(22,"36980949","Ipsum Porta Elit PC","767818537","Chava Savage","2 825 900","Ap #940-6053 Varius Rd.","12345"),
(23,"17689554","Auctor Velit Eget PC","325452597","Hasad Craft","2 515 128","Ap #460-8704 Torquent Rd.","12345"),
(24,"19648664","Sed Nec Metus PC","134381953","Gage Gillespie","2 431 850","Ap #234-3988 Purus, Rd.","12345"),
(25,"20248523","Cras Industries","751229592","Kendall Harrell","2 857 552","878-4420 Quisque Av.","12345"),
(26,"18608177","Iaculis Lacus Foundation","017655440","Acton Cote","2 662 826","9174 Nec St.","12345"),
(27,"46256503","Praesent Interdum Associates","680343704","Zephr Parks","2 252 269","P.O. Box 302, 486 Ipsum. Av.","12345"),
(28,"13712693","Et Risus Foundation","763306735","Jerry Griffin","2 560 168","Ap #380-7375 Mauris Ave","12345"),
(29,"37989897","Nibh Donec Est Industries","291776466","Eagan Stafford","2 530 944","P.O. Box 381, 8787 At, Street","12345"),
(30,"31642714","Quis Tristique Limited","475935821","Zelenia Gilmore","2 371 287","Ap #547-828 Nunc St.","12345"),
(31,"48672989","Eu Dui Cum Company","285401394","Davis Harvey","2 713 221","Ap #744-6026 Tempor St.","12345"),
(32,"6665474","Sed Sapien Industries","461071573","Hermione Stark","2 726 346","644-7364 Sed Ave","12345"),
(33,"38547212","Nunc Sed Pede Limited","123499592","Eaton Ryan","2 480 876","Ap #104-3461 Lobortis Rd.","12345"),
(34,"28512512","Magna Praesent Interdum Foundation","157778812","Sopoline Horn","2 152 413","9278 At, Rd.","12345"),
(35,"38317906","In Foundation","278602339","Troy Trujillo","2 669 699","335-3831 Scelerisque Ave","12345"),
(36,"15311295","Arcu Imperdiet Institute","025889403","Ivana Warner","2 771 072","539-4316 Eget St.","12345"),
(37,"12932533","Sed Pharetra Ltd","510319692","Aurelia Fitzpatrick","2 563 871","2101 Lacus. Rd.","12345"),
(38,"23768831","Integer Foundation","873646467","Drew Ray","2 280 026","P.O. Box 888, 6185 Eu Av.","12345"),
(39,"19328057","Mi Pede Nonummy Foundation","336758461","Cameron Conrad","2 712 132","P.O. Box 695, 9994 Proin Avenue","12345"),
(40,"44102141","Nec Cursus Limited","965180102","Debra Gibson","2 839 122","4007 Duis St.","12345"),
(41,"5750554","Blandit Consulting","105252761","Camille Petersen","2 596 570","P.O. Box 969, 5044 Nunc Rd.","12345"),
(42,"5893588","Libero Mauris Aliquam Foundation","429957384","Briar Hanson","2 029 914","P.O. Box 805, 7192 Ac Street","12345"),
(43,"8387519","Primis Corporation","338962269","George Baker","2 827 442","908-3631 Tempor Street","12345"),
(44,"17459532","Malesuada Fames Ac Inc.","412404899","Hadassah Jackson","2 203 274","Ap #673-535 Scelerisque Road","12345"),
(45,"48039936","Eu Dolor Egestas LLC","761487354","Xander Hebert","2 374 181","Ap #691-5131 Mattis Ave","12345"),
(46,"41614104","Eu Nulla At Ltd","877043133","Brynn Harvey","2 628 205","Ap #574-6804 Tellus. Rd.","12345"),
(47,"11254498","Feugiat Limited","932191976","Brenna Hernandez","2 960 436","2864 Montes, Street","12345"),
(48,"33473988","Dolor Incorporated","672434610","Vivien Rollins","2 093 929","577-1473 Sem Avenue","12345"),
(49,"45021979","Ipsum Dolor Company","765106943","Belle Estrada","2 303 679","397-779 Nisi. Road","12345"),
(50,"22548008","Morbi Metus Vivamus Consulting","566268256","Elaine Bender","2 789 164","2415 Vel St.","12345"),
(51,"46640670","Sed LLP","060957891","Amir Thornton","2 884 624","4612 Nulla. Street","12345"),
(52,"17601743","Neque Ltd","888495728","Lillian Clayton","2 708 725","P.O. Box 499, 5087 Nec Av.","12345"),
(53,"40483777","Tempor Diam Consulting","897853073","Erich Burch","2 871 474","679-9768 Sed Ave","12345"),
(54,"17025826","Nibh Sit Inc.","157852674","Samantha Stark","2 474 837","5901 Eget, Rd.","12345"),
(55,"6695916","A Inc.","026432666","Elmo Bryan","2 374 940","836-3210 Quisque Avenue","12345"),
(56,"43256684","Molestie Pharetra Nibh Company","252779723","Caesar Marshall","2 898 212","P.O. Box 642, 6428 Ipsum Rd.","12345"),
(57,"17587498","Enim Inc.","538264490","Clarke Leach","2 663 269","498-4206 Metus Rd.","12345"),
(58,"46554394","Aenean Limited","558861969","Ethan Santana","2 011 307","P.O. Box 660, 6459 Luctus Street","12345"),
(59,"27924735","Vitae Odio Sagittis Inc.","081181471","Asher Baldwin","2 146 744","8760 Consectetuer St.","12345"),
(60,"27957455","Lacus PC","554575282","Teagan Gallagher","2 841 172","538-2472 Accumsan Street","12345"),
(61,"20531414","A Mi Fringilla Institute","695561118","Josiah Sherman","2 044 172","549-8095 Sed St.","12345"),
(62,"29150060","Turpis Nulla Company","986809838","Tatyana Barry","2 461 968","3991 Odio Avenue","12345"),
(63,"41146685","Sit PC","396277170","Blake Crawford","2 454 633","9571 Velit Rd.","12345"),
(64,"8106983","Cursus Luctus Foundation","763537016","Melanie Pace","2 356 976","P.O. Box 278, 1397 Dis Ave","12345"),
(65,"36669376","Maecenas Iaculis LLP","320578669","Jackson Park","2 983 137","259-3702 Ad Road","12345"),
(66,"40086098","Id Magna Industries","781015326","Joan Britt","2 976 842","621-8027 Ut, Street","12345"),
(67,"48120551","Non Company","090924705","Martha Acosta","2 345 409","713-1567 Dictum Avenue","12345"),
(68,"34383577","Sit Amet Inc.","508704400","Giacomo Meyers","2 762 712","5187 Sem, Street","12345"),
(69,"33846165","Dui In Consulting","047609037","Aaron Fowler","2 691 190","389-8667 In Road","12345"),
(70,"20389493","Habitant Morbi Institute","780245353","Cooper Snow","2 018 030","Ap #464-8411 Sit Av.","12345"),
(71,"31250391","In Industries","598948065","Jenna Mccullough","2 479 765","Ap #975-7104 Feugiat. St.","12345"),
(72,"6462441","Egestas Duis Ac LLP","571164714","Reed Ross","2 209 964","Ap #118-2670 Lectus. Av.","12345"),
(73,"44808626","Velit Dui Industries","281641183","Savannah Pope","2 136 977","358 Est. Av.","12345"),
(74,"15755106","Proin LLC","144195005","Brynne Mccullough","2 200 820","641-5700 Vestibulum Avenue","12345"),
(75,"31458995","Eu Industries","348704164","Shay Copeland","2 110 188","Ap #468-6973 Eros. St.","12345"),
(76,"46612111","Proin Ultrices Inc.","605983311","Harlan Velez","2 597 145","9403 Quisque Rd.","12345"),
(77,"23564739","Eu Odio Consulting","385331947","Reagan Carr","2 091 690","406-6795 Malesuada Street","12345"),
(78,"43271796","Elit Etiam Laoreet Corp.","059228445","Heidi Lynch","2 551 061","353-7773 Donec Av.","12345"),
(79,"13805152","Sodales Purus In Corp.","268352812","Akeem Dickson","2 777 172","Ap #727-9608 Justo. Avenue","12345"),
(80,"38297781","In Hendrerit LLC","860384353","Jemima Estes","2 143 395","169-5391 Fusce Av.","12345"),
(81,"23846596","Egestas Urna Justo Incorporated","791736291","Fallon Kline","2 513 149","P.O. Box 927, 5498 Nunc St.","12345"),
(82,"44328035","Sagittis Nullam Ltd","502634348","Fitzgerald Frederick","2 210 985","Ap #737-7108 Cursus Street","12345"),
(83,"27307156","Fusce Mi Lorem Institute","274910124","Randall Macias","2 342 341","1236 Curabitur St.","12345"),
(84,"10324732","Eu Industries","117535872","Vladimir Carson","2 553 653","P.O. Box 405, 273 Nunc Rd.","12345"),
(85,"22293351","Vulputate Ullamcorper Magna LLC","817194939","Hope Solomon","2 070 750","392-4957 A St.","12345"),
(86,"44024835","Aliquam Corporation","215063363","Wynne Carroll","2 641 930","774-838 Sociis Rd.","12345"),
(87,"44437660","Lorem LLP","934159674","Bell Miles","2 980 411","P.O. Box 293, 2696 Velit. Avenue","12345"),
(88,"13722844","Augue Eu Tellus LLC","319153060","Lillith Ballard","2 072 375","Ap #593-7992 Varius Rd.","12345"),
(89,"26176029","Justo Nec Company","636175192","Lee Herman","2 765 566","P.O. Box 993, 6792 Mattis St.","12345"),
(90,"25758253","Orci Quis Lectus Corp.","756857249","Hammett Salinas","2 120 733","Ap #726-8785 Sem Rd.","12345"),
(91,"22301042","Vitae Erat Vivamus Corp.","286807250","Ulric Raymond","2 952 918","8393 Ut, Ave","12345"),
(92,"24644501","Euismod Corporation","329604987","Josephine Strong","2 004 389","2254 Ultricies Street","12345"),
(93,"14171774","Dis Inc.","455821835","Zeus Mejia","2 832 897","P.O. Box 422, 2245 Dictum. Street","12345"),
(94,"23624647","Ligula Aenean Euismod Ltd","806269874","Azalia Frank","2 549 512","P.O. Box 487, 4915 A, St.","12345"),
(95,"45761042","Ullamcorper Eu Euismod Company","147174593","Melinda Reeves","2 985 539","331-7145 Sit St.","12345"),
(96,"44490590","Malesuada Ut Sem Foundation","312808207","Whitney Jarvis","2 789 877","572-3538 Blandit Street","12345"),
(97,"15864244","Aenean Foundation","015591886","Dawn Richards","2 154 349","Ap #661-3744 Lorem Av.","12345"),
(98,"41113403","Elit Corp.","128582103","Ann Blevins","2 054 283","Ap #933-9848 Pede. Rd.","12345"),
(99,"14860478","Nisl Sem Consequat Ltd","607892072","Jaime England","2 267 606","3661 Mauris, Ave","12345"),
(100,"14429051","Lacinia Mattis Company","307129148","Justin Burnett","2 449 564","2755 Ut Avenue","12345");



/* Rutas */
DELETE FROM `rutas`;
INSERT INTO `rutas` (`id_ruta`,`tarifa`,`descripcion`,`habilitado`) VALUES
(1,"3.30","Cuenca - Machala [Terrestre]",true),
(2,"5.00","Cuenca - Quito [Terrestre]",true),
(3,"2.25","Machala - Guayaquil [Maritimo]",true),
(4,"7.45","Quito - Esmeraldas [Aereo]",true),
(5,"6.00","Loja - Quito [Aereo]",true);



/* Paquetes */
DELETE FROM `paquetes`;
INSERT INTO `paquetes` (`id_paquete`,`tarifa`,`rawDesc`,`desde`,`hasta`,`habilitado`) VALUES
(1,"1.50","Sobre", '0.0', '0.7',true),
(2,"3.00","Ligero", '0.7', '2',true),
(3,"5.45","Mediano", '2', '5.5',true),
(4,"5.45","Grande", '5.5', '10',true),
(5,"5.45","Pesado", '10', '20',true);


/* Admin password */
insert into `admin` values (1, '12345');

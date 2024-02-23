## TUTORIAL 3

Saya hanya mengaplikasikan 3 principle yang ada :

1. SSR
Memisahkan CarController dan ProductController agar tiap class hanya menghandle class nya sendiri

2. DIP
Tidak menggunakan interface konkrit sehingga pemisahan CarController dan ProductController juga termasuk kedalamnya

3. OCP
Terdapat persamaan antara CarRepository dan ProductRepository sehingga saya membuat general interface
yang dapat digunakan oleh Car dan juga Product.

## KELEBIHAN SOLID PRINCIPLE
1. Membuat debugging dan pembacaan program menjadi lebih mudah dan efisien.
2. Pemecahan pada penerapan saya sebelumnya membuatnya lebih jelas dalam penerapan code.
3. Penambahan dan pengurangan fitur menjadi lebih mudah untuk dikelola.

## KEKURANGAN SOLID PRINCIPLE
1. Sangat berpotensi untuk merombak sebagian besar code dikarenakan satu code dengan yang lain saling berhubungan.
2. Membutuhkan waktu tambahan untuk dapat mengerti serta memahami perbaikan code.

## TUTORIAL 2

1. - Code quality issue yang saya fix terdapat pada penggunaan camel case di return value. Menjadi HomePage dan ProductList
   - Menghapus 'public' pada function.

2. Menurut saya, penerapan yang sudah saya terapkan sudah memenuhi konsep CI/CD.
Dengan menggunakan Github Workflows, setiap adanya pembaruan yang kita terapkan pada github, 
akan terjadi CI dengan dilakukannya uji coba dan CD dengan deployment. Untuk detailnya, dilakukan test setiap adanya perubahan pada 'ci.yml' dan akan 
dicek kebersihan codenya dengan 'pmd.yml' dan 'scorecard.yml'. Setelah melalui tahap tersebut, proyek akan dimerge dan redeploy kembali oleh Koyeb.

## BONUS
(90% :(( )
## TUTORIAL 1

## Exercise 1

## Clean Code Principle :

1. Nama Variabel yang Jelas
Variabel yang jelas nama dan fungsinya sangat berpengaruh pada code yang rapih dan bersih sehingga diharapkan
code dapat lebih mudah untuk dibaca.

2. Nama Function yang Jelas dan Baik
Nama function dibuat dengan sejelas mungkin sesuai dengan porsi dan tujuannya dan fokus pada 1 tujuan saja.

3. Menganut paham "Don't comment bad code, rewrite it". Dikarenakan point 1 dan 2 terlaksana, maka tidak diperlukannya comment.

4. Menggunakan branch yang berbeda pada tiap tujuannya.

## Improve Kesalahan

Saat ID product yang akan saya edit tidak berfungsi sehingga saya beralih menggunakan UUID dan pada saat yang bersamaan
juga saya tidak dapat parse ID untuk form edit sehingga saya menambahkan hidden input untuk dapat memaksimalkan fitur edit

## Exercise 2

## (1)
Setelah melakukan testing, saya merasa lebih aman karena dengan dilakukannya testing, saya menjadi yakin bahwa program
yang saya buat berjalan sesuai fungsinya.

- Kuantitas dari banyaknya testing seharusnya tidak dibatasi. Akan tetapi akan lebih baik jika testing lebih sedikit agar lebih efisien
- Walaupun 100%, code belum sepenuhnya terhindar dari bug. Testing tidak menjamin bahwa code bebas dari bug.

## (2)
Menurut saya, jika saya membuat function testing yang mirip dengan yang sudah ditulis sebelumnya, maka function
akan menjadi kurang efisien dari segi cleanliness code dan potensi terkena bug dapat menjadi meningkat.


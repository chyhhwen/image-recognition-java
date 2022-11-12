# 資料庫與影像辨識
`資料庫使用`\
需要引用`mysql-connector-java-8.0.30.jar`\
然後放在 java project's mod\
`sqlset.java`資料庫設定\
`query.java`使用指令\
`1`為新增使用\
`2`為輸出使用
`3`每秒新增
***
`影像辨識`\
需要引用`opencv`\
套用模型`haarcascade_frontalface_alt.xml`
***
`讀取當前時間`\
`DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");`\
`String date = dtf.format(LocalDateTime.now());`
# Data Engineering Hands On: Apache Spark
## Project Setup:
To run this project in your local.Follow the below steps:
1) Open it up in IntelliJ or any other IDE
2) Install Scala plugin by going into Settings (For <a href="https://www.jetbrains.com/help/idea/discover-intellij-idea-for-scala.html">reference</a>)
3) Put the dataset in data directory (data/access.log)
4) run mvn clean install to download all dependencies and build the jar.

Once you run the main class it will read the data/access.log file and parse it using Apache Spark and write the output files in data/logdata/ directory in parquet file format. It will also print the hourly trend table data on the console.


## Dataset Description
Web sever logs contain information on any event that was registered/logged. This contains a lot of insights on website visitors, behavior, crawlers accessing the site, business insights, security issues, and more.
This is a dataset for trying to gain insights from such a file.

Download this dataset by clicking <a href="https://drive.google.com/file/d/1DwIFBu5PvxN7dqL34UA7uyDQAhrIPrbD/view? usp=sharing">here</a>.

## Interactively running the code in Scala shell
1) Setup the shell from run configuration.
2) Select scala REPL 
3) Run the Scala REPL and execute the code by ctrl+alt+X for windows and contorl+command+X for Mac users.

For reference please <a href="https://www.jetbrains.com/help/idea/run-debug-configuration-scala-console.html">visit</a>.

## FAQ's
### what is scala-shell?
This is an interactive way to run the scala code. It is similar to python shell where we interactively run python scripts.

### What is parquet file?
It is highly compressed columnar file format which is optimized for high speed reads and is prominently used in enterprise data warehouses.  Further reads about <a href="https://databricks.com/glossary/what-is-parquet">Apache Parquet.</a>

## Cheers! You are now ready to code



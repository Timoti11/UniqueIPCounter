# UniqueIPCounter
Maximum compact algorithm to find the number of unique IP addresses from a file

## Algorithm description
This Java program converts a dotted-decimal IP address (e.g., `192.168.1.1`) into a single long integer. The conversion is done by parsing the IP address string and using bitwise operations to combine each part into a single 32-bit integer.

The program also keeps track of unique IP addresses using an efficient storage mechanism.

## Features
- Only ~530MB RAM
- Low CPU usage
- 40% faster than others due to bitwise operations
- Clear structure - no 999 files in one package
- Ability to run a jar with arguments instead of manually running it inside IDE
- A separate test class for creating files with a set of random IP addresses (I did not optimize it, it uses a lot of RAM)

## Usage

1. Download jar-file from [Releases](https://github.com/Timoti11/UniqueIPCounter/releases)

2. Run the program with the command line or powershell command
```sh
java -jar UniqueIPCounter.jar <filename>
```
`<filename>` - full or relative path to the txt file.


## Manual build

1. Clone the repository:
    ```sh
    git clone https://github.com/Timoti11/UniqueIPCounter.git
    ```
2. Navigate to the project directory:
    ```sh
    cd UniqueIPCounter
    ```
3. Use maven for build:
    ```sh
    mvn clean install
    ```
4. Navigate to the build directory:
    ```sh
    cd target
    ```
5. Run the program with the command line or powershell command
    ```sh
    java -jar UniqueIPCounter.jar <filename>
    ```
`<filename>` - full or relative path to the txt file.
   
---
[Task file](https://ecwid-vgv-storage.s3.eu-central-1.amazonaws.com/ip_addresses.zip) (120Gb) processed in 16 minutes without SSD.
<br> `Found 1000000000 unique IP addresses!`

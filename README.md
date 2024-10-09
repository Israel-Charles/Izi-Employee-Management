# Izi Employee Management

>[!Note]
> This is an ongoing project. It is currently in its first stage of life. As of right now, CLI user interaction structure is set up, CLI Interface helper functons are set up, and company registration is set up on local storage.

Comprehensive employee management system aimed at improving company operations by providing essential tools for managing employee and company data. The software will be able to be used via a command-line interface (CLI), web interface, or local graphical user interface.

Key features include:
- **Employee Management**: Easily register, modify, and remove employees or volunteers, track their working hours, and generate detailed pay stubs.
- **Time Tracking and Reporting**: Track employee working hours and generate various reports, including payroll and performance reports, allowing companies to stay organized and compliant with payroll requirements.
- **Company Information Management**: During initial setup, the company can input vital information such as the company name, address, phone number, and email, which can later be modified through the software. This information is saved in a configuration file that is validated during each startup.
- **Configuration and Storage Options**: The system offers a configurable setup that allows users to choose between storing data locally or on a MySQL server, providing flexibility based on the company’s data management needs.

The project emphasizes modularity, making it easier for future developers to extend the system’s functionality or integrate it with other services. The user-friendly setup process ensures the program is accessible for companies of various sizes and technical proficiencies, providing them with a robust tool for employee management.

## Running Current Stage

1. **Compile the Java files** with this command:
   ```bash
   javac -d out src/iziManagement/*.java src/helpfulFunctionsPckg/*.java
   ```

2. **Run the program** by referencing the classpath:
   ```bash
   java -cp out iziManagement.SetupAndRun
   ```

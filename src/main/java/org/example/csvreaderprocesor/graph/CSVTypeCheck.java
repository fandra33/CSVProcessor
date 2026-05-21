package org.example.csvreaderprocesor.graph;

import javafx.scene.control.Alert;

import java.util.List;

public class CSVTypeCheck {
    public static final List<String> VCUHeaders = List.of(
            "Timestamp", // Coloana adăugată pentru timpul de recepție
            "NEW_Motor_Torque",
            "NEW_Motor_Speed",
            "Motor_Torque",
            "Motor_Speed",
            "Pack_Voltage_MSB",
            "Pack_Voltage_LSB",
            "Pack_Current_MSB",
            "Pack_Current_LSB",
            "SOC",
            "Cell1_Temperature",
            "Cell2_Temperature",
            "Cell3_Temperature",
            "Cell4_Temperature",
            "Cell1_Voltage",
            "Cell2_Voltage",
            "Cell3_Voltage",
            "Cell4_Voltage",
            "M_set",
            "N_Lim",
            "HVM_CH1_Voltage",
            "HVM_CH1_Raw",
            "Wheel_Angle1",
            "Wheel_Angle2",
            "RPM_FL",
            "RPM_FR",
            "RPM_RL",
            "RPM_RR",
            "Gyro_X",
            "Gyro_Y",
            "Gyro_Z",
            "Acel_X",
            "Acel_Y",
            "Acel_Z",
            "HVM_CH0_Voltage",
            "HVM_CH0_Raw",
            "BAT_Current_Raw",
            "BAT_Current",
            "State_Of_Charge",
            "Cell_Min_Volt_GL",
            "Cell_Min_Temp_GL",
            "Cell_Max_Volt_GL",
            "Cell_Max_Temp_GL",
            "Analog_sensor1",
            "Analog_sensor2",
            "Temperature_sensor1",
            "Temperature_sensor2",
            "Brake_pressure1",
            "Brake_pressure2",
            "Throttle1",
            "Throttle2",
            "LS_out_1",
            "LS_out_2",
            "LS_out_3",
            "LS_out_4",
            "LS_out_5",
            "LS_out_6",
            "Digital_IN_1",
            "Digital_IN_2",
            "Digital_IN_3",
            "Digital_IN_4",
            "Digital_IN_5",
            "Digital_IN_6",
            "ADC_Temp_RAW1",
            "ADC_Temp_RAW2",
            "ADC_RAW1",
            "ADC_RAW2",
            "ADC_RAW3",
            "ADC_RAW4",
            "ADC_RAW5",
            "ADC_RAW6",
            "N_CmdRamp",
            "N_Actual",
            "N_Actual_Filt",
            "N_cmd",
            "Iq_Actual",
            "Vout",
            "T_Motor",
            "T_Igbt",
            "T_Air",
            "Vdc_Bus"
    );
    static int nrVCUHeaders = VCUHeaders.size();
    public static final List<String> BMSHeaders = List.of(
            "Timestamp",
            "HVM_CH1_Voltage",
            "HVM_CH1_Raw",
            "Cell_Max_Voltage_1",
            "Cell_Max_Temperature_1",
            "Cell_Min_Temperature_1",
            "Cell_Min_Voltage_1",
            "State_Machine",
            "State_Of_Charge",
            "Cell_Min_Temperature_GL",
            "Cell_Max_Temperature_GL",
            "Cell_Min_Voltage_GL",
            "Cell_Max_Voltage_GL",
            "BAT_Current_Raw",
            "BAT_Current",
            "HVM_CH0_Voltage",
            "HVM_CH0_Raw",
            // Temperaturi Celule slave 4
            "Temperature_Cell_425", "Temperature_Cell_426", "Temperature_Cell_427", "Temperature_Cell_428",
            "Temperature_Cell_421", "Temperature_Cell_422", "Temperature_Cell_423", "Temperature_Cell_424",
            "Temperature_Cell_417", "Temperature_Cell_418", "Temperature_Cell_419", "Temperature_Cell_420",
            "Temperature_Cell_416", "Temperature_Cell_415", "Temperature_Cell_414", "Temperature_Cell_413",
            "Temperature_Cell_412", "Temperature_Cell_411", "Temperature_Cell_410", "Temperature_Cell_409",
            "Temperature_Cell_408", "Temperature_Cell_407", "Temperature_Cell_406", "Temperature_Cell_405",
            "Temperature_Cell_404", "Temperature_Cell_403", "Temperature_Cell_402", "Temperature_Cell_401",
            // Temperaturi Celule slave 3
            "Temperature_Cell_325", "Temperature_Cell_326", "Temperature_Cell_327", "Temperature_Cell_328",
            "Temperature_Cell_321", "Temperature_Cell_322", "Temperature_Cell_323", "Temperature_Cell_324",
            "Temperature_Cell_317", "Temperature_Cell_318", "Temperature_Cell_319", "Temperature_Cell_320",
            "Temperature_Cell_316", "Temperature_Cell_315", "Temperature_Cell_314", "Temperature_Cell_313",
            "Temperature_Cell_312", "Temperature_Cell_311", "Temperature_Cell_310", "Temperature_Cell_309",
            "Temperature_Cell_308", "Temperature_Cell_307", "Temperature_Cell_306", "Temperature_Cell_305",
            "Temperature_Cell_304", "Temperature_Cell_303", "Temperature_Cell_302", "Temperature_Cell_301",
            // Temperaturi Celule slave 2
            "Temperature_Cell_225", "Temperature_Cell_226", "Temperature_Cell_227", "Temperature_Cell_228",
            "Temperature_Cell_221", "Temperature_Cell_222", "Temperature_Cell_223", "Temperature_Cell_224",
            "Temperature_Cell_217", "Temperature_Cell_218", "Temperature_Cell_219", "Temperature_Cell_220",
            "Temperature_Cell_216", "Temperature_Cell_215", "Temperature_Cell_214", "Temperature_Cell_213",
            "Temperature_Cell_212", "Temperature_Cell_211", "Temperature_Cell_210", "Temperature_Cell_209",
            "Temperature_Cell_208", "Temperature_Cell_207", "Temperature_Cell_206", "Temperature_Cell_205",
            "Temperature_Cell_204", "Temperature_Cell_203", "Temperature_Cell_202", "Temperature_Cell_201",
            // Temperaturi Celule slave 1
            "Temperature_Cell_125", "Temperature_Cell_126", "Temperature_Cell_127", "Temperature_Cell_128",
            "Temperature_Cell_121", "Temperature_Cell_122", "Temperature_Cell_123", "Temperature_Cell_124",
            "Temperature_Cell_117", "Temperature_Cell_118", "Temperature_Cell_119", "Temperature_Cell_120",
            "Temperature_Cell_116", "Temperature_Cell_115", "Temperature_Cell_114", "Temperature_Cell_113",
            "Temperature_Cell_112", "Temperature_Cell_111", "Temperature_Cell_110", "Temperature_Cell_109",
            "Temperature_Cell_108", "Temperature_Cell_107", "Temperature_Cell_106", "Temperature_Cell_105",
            "Temperature_Cell_104", "Temperature_Cell_103", "Temperature_Cell_102", "Temperature_Cell_101",
            // Temperaturi Celule slave 0
            "Temperature_Cell_025", "Temperature_Cell_026", "Temperature_Cell_027", "Temperature_Cell_028",
            "Temperature_Cell_021", "Temperature_Cell_022", "Temperature_Cell_023", "Temperature_Cell_024",
            "Temperature_Cell_017", "Temperature_Cell_018", "Temperature_Cell_019", "Temperature_Cell_020",
            "Temperature_Cell_016", "Temperature_Cell_015", "Temperature_Cell_014", "Temperature_Cell_013",
            "Temperature_Cell_012", "Temperature_Cell_011", "Temperature_Cell_010", "Temperature_Cell_009",
            "Temperature_Cell_008", "Temperature_Cell_007", "Temperature_Cell_006", "Temperature_Cell_005",
            "Temperature_Cell_004", "Temperature_Cell_003", "Temperature_Cell_002", "Temperature_Cell_001",
            // Tensiuni Celule slave 4
            "Voltage_Cell425", "Voltage_Cell426", "Voltage_Cell427", "Voltage_Cell428",
            "Voltage_Cell421", "Voltage_Cell422", "Voltage_Cell423", "Voltage_Cell424",
            "Voltage_Cell417", "Voltage_Cell418", "Voltage_Cell419", "Voltage_Cell420",
            "Voltage_Cell416", "Voltage_Cell415", "Voltage_Cell414", "Voltage_Cell413",
            "Voltage_Cell412", "Voltage_Cell411", "Voltage_Cell410", "Voltage_Cell409",
            "Voltage_Cell408", "Voltage_Cell407", "Voltage_Cell406", "Voltage_Cell405",
            "Voltage_Cell404", "Voltage_Cell403", "Voltage_Cell402", "Voltage_Cell401",
            // Tensiuni Celule slave 3
            "Voltage_Cell325", "Voltage_Cell326", "Voltage_Cell327", "Voltage_Cell328",
            "Voltage_Cell321", "Voltage_Cell322", "Voltage_Cell323", "Voltage_Cell324",
            "Voltage_Cell317", "Voltage_Cell318", "Voltage_Cell319", "Voltage_Cell320",
            "Voltage_Cell316", "Voltage_Cell315", "Voltage_Cell314", "Voltage_Cell313",
            "Voltage_Cell312", "Voltage_Cell311", "Voltage_Cell310", "Voltage_Cell309",
            "Voltage_Cell308", "Voltage_Cell307", "Voltage_Cell306", "Voltage_Cell305",
            "Voltage_Cell304", "Voltage_Cell303", "Voltage_Cell302", "Voltage_Cell301",
            // Tensiuni Celule slave 2
            "Voltage_Cell225", "Voltage_Cell226", "Voltage_Cell227", "Voltage_Cell228",
            "Voltage_Cell221", "Voltage_Cell222", "Voltage_Cell223", "Voltage_Cell224",
            "Voltage_Cell217", "Voltage_Cell218", "Voltage_Cell219", "Voltage_Cell220",
            "Voltage_Cell216", "Voltage_Cell215", "Voltage_Cell214", "Voltage_Cell213",
            "Voltage_Cell212", "Voltage_Cell211", "Voltage_Cell210", "Voltage_Cell209",
            "Voltage_Cell208", "Voltage_Cell207", "Voltage_Cell206", "Voltage_Cell205",
            "Voltage_Cell204", "Voltage_Cell203", "Voltage_Cell202", "Voltage_Cell201",
            // Tensiuni Celule slave 1
            "Voltage_Cell125", "Voltage_Cell126", "Voltage_Cell127", "Voltage_Cell128",
            "Voltage_Cell121", "Voltage_Cell122", "Voltage_Cell123", "Voltage_Cell124",
            "Voltage_Cell117", "Voltage_Cell118", "Voltage_Cell119", "Voltage_Cell120",
            "Voltage_Cell116", "Voltage_Cell115", "Voltage_Cell114", "Voltage_Cell113",
            "Voltage_Cell112", "Voltage_Cell111", "Voltage_Cell110", "Voltage_Cell109",
            "Voltage_Cell108", "Voltage_Cell107", "Voltage_Cell106", "Voltage_Cell105",
            "Voltage_Cell104", "Voltage_Cell103", "Voltage_Cell102", "Voltage_Cell101",
            // Tensiuni Celule slave 0
            "Voltage_Cell025", "Voltage_Cell026", "Voltage_Cell027", "Voltage_Cell028",
            "Voltage_Cell021", "Voltage_Cell022", "Voltage_Cell023", "Voltage_Cell024",
            "Voltage_Cell017", "Voltage_Cell018", "Voltage_Cell019", "Voltage_Cell020",
            "Voltage_Cell016", "Voltage_Cell015", "Voltage_Cell014", "Voltage_Cell013",
            "Voltage_Cell012", "Voltage_Cell011", "Voltage_Cell010", "Voltage_Cell009",
            "Voltage_Cell008", "Voltage_Cell007", "Voltage_Cell006", "Voltage_Cell005",
            "Voltage_Cell004", "Voltage_Cell003", "Voltage_Cell002", "Voltage_Cell001",
            // Statusuri Agregate slaves
            "Cell_Min_Temperature_4", "Cell_Max_Temperature_4", "Cell_Min_Voltage_4", "Cell_Max_Voltage_4",
            "Cell_Min_Temperature_3", "Cell_Max_Temperature_3", "Cell_Min_Voltage_3", "Cell_Max_Voltage_3",
            "Cell_Min_Temperature_2", "Cell_Max_Temperature_2", "Cell_Min_Voltage_2", "Cell_Max_Voltage_2",
            "Cell_Min_Temperature_0", "Cell_Max_Temperature_0", "Cell_Min_Voltage_0", "Cell_Max_Voltage_0"
    );
    static int nrBMSHeaders = BMSHeaders.size();
    public static boolean itsVCUorBMS(List<String> headers)
    {
        if (headers.size() == nrVCUHeaders && headers.containsAll(VCUHeaders)) {
            return true;
        }
        else if (headers.size() == nrBMSHeaders && headers.containsAll(BMSHeaders)) {
            return true;
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("CSV File Error");
            alert.setContentText("The CSV file does not match the expected format for VCU or BMS data.");
            alert.showAndWait();
            return false;
        }

    }
}

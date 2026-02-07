package org.example.csvreaderprocesor.graph;

import javafx.scene.control.Alert;

import java.util.List;

public class CSVTypeCheck {
    static List<String> VCUHeaders = List.of(
            // Metadata
            "Timestamp", "Message_ID", "Message_Name", "Sender_Node",

            // Independent / Global Signals (BO_ 3221225472)
            "NEW_Motor_Torque", "NEW_Motor_Speed", "Motor_Torque", "Motor_Speed",
            "Pack_Voltage_MSB", "Pack_Voltage_LSB", "Pack_Current_MSB", "Pack_Current_LSB",
            "SOC", "Cell4_Temperature", "Cell3_Temperature", "Cell2_Temperature", "Cell1_Temperature",
            "Cell4_Voltage", "Cell3_Voltage", "Cell2_Voltage", "Cell1_Voltage",

            // Motion Data
            "Wheel_Angle2", "Wheel_Angle1", "RPM_RR", "RPM_RL", "RPM_FR", "RPM_FL",
            "Gyro_Z", "Gyro_Y", "Gyro_X", "Acel_Z", "Acel_Y", "Acel_X",

            // High Voltage & Battery Management
            "HVM_CRC", "HVM_Counter", "HVM_CH1_Voltage", "HVM_CH0_Voltage", "HVM_CH1_Raw", "HVM_CH0_Raw",
            "BAT_Current_Raw", "BAT_Current", "State_Of_Charge", "State_Master",
            "Cell_Min_Volt_GL", "Cell_Min_Temp_GL", "Cell_Max_Volt_GL", "Cell_Max_Temp_GL",

            // Errors & Analog Sensors
            "Analog_IN_S_L", "Analog_IN_S_H", "APPS_errors",
            "Analog_sensor2", "Analog_sensor1", "Temperature_sensor2", "Temperature_sensor1",
            "Brake_pressure2", "Brake_pressure1", "Throttle2", "Throttle1",

            // I/O & Raw ADC
            "LS_out_6", "LS_out_5", "LS_out_4", "LS_out_3", "LS_out_2", "LS_out_1",
            "Digital_IN_6", "Digital_IN_5", "Digital_IN_4", "Digital_IN_3", "Digital_IN_2", "Digital_IN_1",
            "ADC_Temp_RAW2", "ADC_Temp_RAW1", "ADC_RAW6", "ADC_RAW5", "ADC_RAW4", "ADC_RAW3", "ADC_RAW2", "ADC_RAW1",

            // BMC Communication (Send & Rcv Multiplexed Signals)
            "User_Key", "Send_Mux", "M_set", "N_Lim", "N_CmdRamp", "Rcv_Mux",
            "N_Actual", "N_Actual_Filt", "Firmware", "HW_Current_Meas", "VdcBus_HW_Meas",
            "T_Motor_NTC", "N_cmd", "Iq_Actual", "Vout", "T_Motor", "T_Igbt",
            "T_Air", "FB_Pole", "Vdc_Bus", "HW_ID"
    );
    static int nrVCUHeaders = VCUHeaders.size();
    static List<String> BMSHeaders = List.of(
            // Metadata
            "Timestamp", "Message_ID", "Message_Name", "Sender_Node",

            // Vector Independent / Global Signals
            "NEW_Motor_Torque", "NEW_Motor_Speed", "Motor_Torque", "Motor_Speed",
            "Pack_Voltage_MSB", "Pack_Voltage_LSB", "Pack_Current_MSB", "Pack_Current_LSB",
            "SOC", "Cell4_Temperature", "Cell3_Temperature", "Cell2_Temperature", "Cell1_Temperature",
            "Cell4_Voltage", "Cell3_Voltage", "Cell2_Voltage", "Cell1_Voltage",

            // Wheel & Motion
            "Wheel_Angle1", "Wheel_Angle2", "RPM_FL", "RPM_FR", "RPM_RL", "RPM_RR",
            "Gyro_X", "Gyro_Y", "Gyro_Z", "Acel_X", "Acel_Y", "Acel_Z",

            // HVM & Electrical
            "HVM_CRC", "HVM_Counter", "HVM_CH1_Voltage", "HVM_CH0_Voltage", "HVM_CH1_Raw", "HVM_CH0_Raw",
            "BAT_Current_Raw", "BAT_Current", "State_Of_Charge", "State_Master",
            "Cell_Min_Volt_GL", "Cell_Min_Temp_GL", "Cell_Max_Volt_GL", "Cell_Max_Temp_GL",

            // Errors & Controls
            "Analog_IN_S_L", "Analog_IN_S_H", "APPS_errors",
            "Temperature_sensor2", "Temperature_sensor1", "Analog_sensor2", "Analog_sensor1",
            "Brake_pressure2", "Brake_pressure1", "Throttle2", "Throttle1",

            // I/O Raw
            "LS_out_6", "LS_out_5", "LS_out_4", "LS_out_3", "LS_out_2", "LS_out_1",
            "Digital_IN_6", "Digital_IN_5", "Digital_IN_4", "Digital_IN_3", "Digital_IN_2", "Digital_IN_1",
            "ADC_Temp_RAW2", "ADC_Temp_RAW1", "ADC_RAW6", "ADC_RAW5", "ADC_RAW4", "ADC_RAW3", "ADC_RAW2", "ADC_RAW1",

            // Communication (Muxed & Keys)
            "User_Key", "Send_Mux", "M_set", "N_Lim", "N_CmdRamp", "Rcv_Mux", "N_Actual",
            "N_Actual_Filt", "Firmware", "HW_Current_Meas", "VdcBus_HW_Meas", "T_Motor_NTC",
            "N_cmd", "Iq_Actual", "Vout", "T_Motor", "T_Igbt", "T_Air", "FB_Pole", "Vdc_Bus", "HW_ID"
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

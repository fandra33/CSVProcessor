package org.example.csvreaderprocesor.graph;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class CSVTypeCheck {
    public static final ArrayList<String> HVMFrameFile = new ArrayList<>(
            List.of("timestamp_seconds", "timestamp_microseconds", "can_id", "can_dlc",
                    "hvm_ch0_raw", "hvm_ch1_raw", "hvm_ch0_voltage", "hvm_ch1_voltage")
    );
    public static final ArrayList<String> CurrentFrameFile = new ArrayList<>(
            List.of("timestamp_seconds", "timestamp_microseconds", "can_id", "can_dlc",
                    "bat_current", "bat_current_raw")
    );
    public static final ArrayList<String> SOCFrameFile = new ArrayList<>(
            List.of("timestamp_seconds", "timestamp_microseconds", "can_id", "can_dlc",
                    "state_master", "state_master")
    );
    public static final ArrayList<String> StatusGlobalFrameFile = new ArrayList<>(
            List.of("timestamp_seconds", "timestamp_microseconds", "can_id", "can_dlc",
                    "cell_max_temp_gl", "cell_max_volt_gl", "cell_min_temp_gl", "cell_min_volt_gl", "hvm_ch1_voltage", "power")
    );
    public static final ArrayList<String> EroriFrameFile = new ArrayList<>(
            List.of("timestamp_seconds", "timestamp_microseconds", "can_id", "can_dlc",
                    "analog_in_s_h", "analog_in_s_l", "apps_errors")
    );
    public static final ArrayList<String> ControlParameters1FrameFile = new ArrayList<>(
            List.of("timestamp_seconds", "timestamp_microseconds", "can_id", "can_dlc",
                    "motor_speed", "motor_torque", "new_motor_speed", "new_motor_torque")
    );
    public static final ArrayList<String> ControlParameters2FrameFile = new ArrayList<>(
            List.of("timestamp_seconds", "timestamp_microseconds", "can_id", "can_dlc",
                    "brake_pressure1", "brake_pressure2", "throttle1", "throttle2")
    );
    public static final ArrayList<String> ControlParameters3FrameFile = new ArrayList<>(
            List.of("timestamp_seconds", "timestamp_microseconds", "can_id", "can_dlc",
                    "analog_sensor1", "analog_sensor2", "temperature_sensor1", "temperature_sensor2")
    );
    public static final ArrayList<String> DigitalOutRawFrameFile = new ArrayList<>(
            List.of("timestamp_seconds", "timestamp_microseconds", "can_id", "can_dlc",
                    "ls_out_1", "ls_out_2", "ls_out_3", "ls_out_4", "ls_out_5", "ls_out_6")
    );
    public static final ArrayList<String> DigitalInRawFrameFile = new ArrayList<>(
            List.of("timestamp_seconds", "timestamp_microseconds", "can_id", "can_dlc",
                    "digital_in_1", "digital_in_2", "digital_in_3", "digital_in_4", "digital_in_5", "digital_in_6")
    );
    public static final ArrayList<String> ADCRawFrameFile = new ArrayList<>(
            List.of("timestamp_seconds", "timestamp_microseconds", "can_id", "can_dlc",
                    "adc_raw1", "adc_raw2", "adc_raw3", "adc_raw4", "adc_raw5", "adc_raw6", "adc_temp_raw1", "adc_temp_raw2")
    );
    public static final ArrayList<String> SendFrameFile = new ArrayList<>(
            List.of("timestamp_seconds", "timestamp_microseconds", "can_id", "can_dlc",
                    "send_mux", "m_set")
    );
    public static final ArrayList<String> RCVFrameFile = new ArrayList<>(
            List.of("timestamp_seconds", "timestamp_microseconds", "can_id", "can_dlc",
                    "n_cmd", "n_lim", "t_air", "t_igbt", "t_motor")
    );
    public static final List<ArrayList<String>> AllFrameFiles = List.of(
            HVMFrameFile,
            CurrentFrameFile,
            SOCFrameFile,
            StatusGlobalFrameFile,
            EroriFrameFile,
            ControlParameters1FrameFile,
            ControlParameters2FrameFile,
            ControlParameters3FrameFile,
            DigitalOutRawFrameFile,
            DigitalInRawFrameFile,
            ADCRawFrameFile,
            SendFrameFile,
            RCVFrameFile
    );

    public static boolean ValidCSV(List<String> headers) {
        for (ArrayList<String> FrameFile : AllFrameFiles) {
            if (headers.containsAll(FrameFile)) {
                return true;
            }
        }
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("CSV File Error");
        alert.setContentText("Fisierul CSV nu este potrivit");
        alert.showAndWait();
        return false;
    }
}
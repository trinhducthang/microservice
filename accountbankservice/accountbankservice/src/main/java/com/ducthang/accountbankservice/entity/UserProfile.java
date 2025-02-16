package com.ducthang.accountbankservice.entity;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfile {
    @JsonProperty("id")  // Đảm bảo trường "id" ánh xạ đúng với key "id" trong JSON
    String id;

    @JsonProperty("email")
    String email;

    @JsonProperty("firstName")
    String firstName;

    @JsonProperty("lastName")
    String lastName;

    @JsonProperty("dob")
    @JsonFormat(pattern = "yyyy-MM-dd")  // Đảm bảo ánh xạ ngày tháng đúng định dạng
    LocalDate dob;

    @JsonProperty("city")
    String city;

    @JsonProperty("banks")
    String banks;
}

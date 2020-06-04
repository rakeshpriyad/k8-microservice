/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.test.branch.controller;

import com.test.branch.model.Branch;
import com.test.branch.model.Address;
import lombok.Data;

import java.time.LocalDate;

/**
 */
@Data
public class EmpRequest {
    private Integer id;
    private String empNo;
    private String empName;
    private String age;
    private LocalDate dob;
    private Branch branch;
    private Address address;

}

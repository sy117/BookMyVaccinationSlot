package com.sklearns.vaccinationslotnotifier.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Sessions {

    private List<Session> sessions;
}

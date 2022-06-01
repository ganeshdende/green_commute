package com.zemoso.greencommute.exception;

public class SkillsNotFoundException extends RuntimeException{

    public SkillsNotFoundException(String message) {
        super(message);
    }

    public SkillsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SkillsNotFoundException(Throwable cause) {
        super(cause);
    }
}

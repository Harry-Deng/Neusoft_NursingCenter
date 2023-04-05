package com.neusoft.entity;
/*
 * @Author DengYimo
 * @Date  4:46
 * @Description This is description of class
 * @Since version-1.0
 */
public class ModelListShow {
    private String id;
    private String content;
    private String mode;
/*
 * @Author DengYimo
 * @Date  4:46
 * @Description This is description of method
 * @Param [id, content, mode]
 * @Return
 * @Since version-1.0
 */
    public ModelListShow(String id, String content, String mode) {
        this.id = id;
        this.content = content;
        this.mode = mode;
    }
/*
 * @Author DengYimo
 * @Date  4:46
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getMode() {
        return mode;
    }
/*
 * @Author DengYimo
 * @Date  4:46
 * @Description This is description of method
 * @Param [mode]
 * @Return void
 * @Since version-1.0
 */
    public void setMode(String mode) {
        this.mode = mode;
    }
/*
 * @Author DengYimo
 * @Date  4:46
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getId() {
        return id;
    }
/*
 * @Author DengYimo
 * @Date  4:47
 * @Description This is description of method
 * @Param [id]
 * @Return void
 * @Since version-1.0
 */
    public void setId(String id) {
        this.id = id;
    }
/*
 * @Author DengYimo
 * @Date  4:47
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getContent() {
        return content;
    }
/*
 * @Author DengYimo
 * @Date  4:47
 * @Description This is description of method
 * @Param [content]
 * @Return void
 * @Since version-1.0
 */
    public void setContent(String content) {
        this.content = content;
    }
}

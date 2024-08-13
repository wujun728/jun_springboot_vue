package com.ruoyi.qixing.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import org.apache.commons.compress.utils.Lists;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wujun
 */
@RestController
@RequestMapping("/qixing")
public class QixingController extends BaseController
{

    //@PreAuthorize("@ss.hasPermi('tool:gen:query')")
    @GetMapping(value = "/test")
    public AjaxResult getInfo()
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("info", "sucess");
        map.put("rows", Lists.newArrayList());
        return success(map);
    }

}
package com.social.converter;


import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.social.enums.GenderEnum;
import lombok.Data;

/**
 * @Author ycshang
 * @Date 2023/7/13
 * @Description 性别转换器
 */
public class GenderConverter implements Converter<Integer> {

	@Override
	public Class<?> supportJavaTypeKey() {
		return Integer.class;
	}

	@Override
	public CellDataTypeEnum supportExcelTypeKey() {
		return CellDataTypeEnum.STRING;
	}

	@Override
	public Integer convertToJavaData(ReadConverterContext<?> context) {
		return GenderEnum.convert(context.getReadCellData().getStringValue()).getValue();
	}

	@Override
	public WriteCellData<?> convertToExcelData(WriteConverterContext<Integer> context) {
		return new WriteCellData<>(GenderEnum.convert(context.getValue()).getName());

	}


}

package com.nit.service;

public sealed interface Services permits ServicesImp {

	public abstract int  insertDataToDb(ProductsDto product,Orders order) ;
}

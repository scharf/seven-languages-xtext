package org.xtext.mongobeans

import com.mongodb.DBObject

import static org.xtext.mongobeans.WrappingUtil.*

class WrappingUtil {
	
	def static IMongoBean wrap(DBObject dbObject) {
		val javaClassName = dbObject.get(org::xtext::mongobeans::IMongoBean::JAVA_CLASS_KEY)?.toString
		val javaClass = typeof(WrappingUtil).classLoader.loadClass(javaClassName)
		if(typeof(IMongoBean).isAssignableFrom(javaClass)) {
			val constructor = javaClass.getConstructor(typeof(DBObject))
			constructor.newInstance(dbObject) as IMongoBean
		} else {
			throw new IllegalStateException('''Stored javaClass '«javaClassName»' does not extend '«typeof(IMongoBean).simpleName»'«»''')
		}
	}
	
	def static <T extends IMongoBean> T wrapAndCast(DBObject dbObject) {
		wrap(dbObject) as T
	} 
	
	def static DBObject unwrap(Object wrapper) {
		if(!(wrapper instanceof IMongoBean))
			throw new IllegalArgumentException("Invalid type")
		else 
			(wrapper as IMongoBean).getDbObject
	}

}
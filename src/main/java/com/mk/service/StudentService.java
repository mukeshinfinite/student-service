package com.mk.service;


import com.mk.entity.Student;
import com.mk.feignclients.AddressFeignClient;
import com.mk.request.CreateStudentRequest;
import com.mk.repository.StudentRepository;
//import com.mk.response.AddressResponse;
import com.mk.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

//	@Autowired
//	WebClient webClient;


	@Autowired(required=true)
	AddressFeignClient addressFeignClient;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		
		student.setAddressId(createStudentRequest.getAddressId());
		student = studentRepository.save(student);

		StudentResponse studentResponse = new StudentResponse(student);
		//studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));


		return studentResponse;
	}
	
	public StudentResponse getById (long id) {
		Student student = studentRepository.findById(id).get();

		StudentResponse studentResponse = new StudentResponse(student);
		//e.g. for WebClient
	//	studentResponse.setAddressResponse(getAddressById(student.getAddressId()));

		//e.g for FeignClient
		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));

		return studentResponse;
	}

//	public AddressResponse getAddressById(long addressId){
//		Mono<AddressResponse> addressResponse = webClient.get()
//				.uri("/getById/" + addressId)
//				.retrieve().bodyToMono(AddressResponse.class);
//
//		return addressResponse.block();
//	}
}

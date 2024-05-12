package tgobmdev.pessoaapi.mapper

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import tgobmdev.pessoaapi.api.zipcode.response.AddressInfo
import tgobmdev.pessoaapi.entity.AddressEntity
import tgobmdev.pessoaapi.request.AddressRequest
import tgobmdev.pessoaapi.response.AddressDetailsResponse
import tgobmdev.pessoaapi.response.AddressInfoWithPeopleResponse

@Mapper(componentModel = "spring", uses = [PersonMapper::class])
interface AddressMapper {
    @Mappings(
        Mapping(source = "addressInfo.result.street", target = "street"),
        Mapping(source = "addressRequest.zipcode", target = "zipcode"),
        Mapping(source = "addressRequest.streetNumber", target = "streetNumber"),
        Mapping(source = "addressInfo.result.city", target = "city"),
        Mapping(source = "addressInfo.result.state", target = "state"),
        Mapping(source = "addressInfo.result.stateShortname", target = "stateShortname"),
        Mapping(target = "personEntities", ignore = true)
    )
    fun toEntity(addressInfo: AddressInfo, addressRequest: AddressRequest): AddressEntity

    fun toAddressDetailsResponse(addressEntities: AddressEntity): AddressDetailsResponse

    fun toAddressDetailsResponseList(addressEntities: List<AddressEntity>): List<AddressDetailsResponse>

    @Mappings(
        Mapping(source = "addressEntity", target = "addressDetailsResponse"),
        Mapping(source = "addressEntity.personEntities", target = "personDetailsResponseList")
    )
    fun toAddressInfoWithPeopleResponse(addressEntity: AddressEntity): AddressInfoWithPeopleResponse
}
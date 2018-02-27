package com.busiwave.boot;

import com.busiwave.boot.controller.ShipwreckController;
import com.busiwave.boot.model.Shipwreck;
import com.busiwave.boot.repository.ShipwreckRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShipwreckControllerTest {

    @InjectMocks
    private ShipwreckController sc;

    @Mock
    private ShipwreckRepository shipwreckRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Ignore
    public void testShipwreckGet() {

        Shipwreck wreck = sc.get(1L);
        assertEquals(1L, wreck.getId().longValue());
    }

    @Test
    public void testShipwreckGet2() {
        Shipwreck sw = new Shipwreck();
        sw.setId(2L);
        when(shipwreckRepository.findOne(2L)).thenReturn(sw);

        Shipwreck wreck = sc.get(2L);

        verify(shipwreckRepository).findOne(2L);

        //assertEquals(2L, wreck.getId().longValue());
        assertThat(wreck.getId(), is(2L));
    }
}
